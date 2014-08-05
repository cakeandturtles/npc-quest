package entities;

import entities.helpers.Txt;
import Levels.Room;
import Levels.World;
import Managers.ResourceManager;

public class NPC extends GameMover{
	public int npc_id;
	public final static int MAX_NPCS = 6;
	public String whatdidisay = "";
	public boolean speaking = false;
	public boolean fade_away = false;
	public String voice = "talk_next";
	public int fade_time = 0;
	public int fade_time_limit = 120;
	
	public static String GetVoice(int npc_id){
		switch (npc_id){
			case 0: default: return "skull_voice";
			case 1: return "pox_voice";
			case 2: return "tree_voice";
			case 3: return "owl_voice";
			case 4: return "bird_voice";
			case 5: return "meow_voice";
			case 6: return "tinymeow_voice";
		}
	}
	
	public NPC(float x, float y, int npc_id, String voice){
		super(x, y, 0, 0, 16, 16, "npc_sheet");
		type = "NPC";
		solid = true;
		this.npc_id = npc_id;
		this.voice = voice;
		
		animation.abs_ani_y = 2*npc_id*animation.frame_height;
	}
	
	public NPC(float x, float y, int npc_id, String voice, String img_name){
		super(x, y, 0, 0, 16, 16, img_name);
		type = "NPC";
		solid = true;
		this.npc_id = npc_id;
		this.voice = voice;
		
		animation.abs_ani_y = 2*npc_id*animation.frame_height;
	}
	
	@Override
	public void Restart(){
		lb = 0;
		tb = 0;
		rb = 16;
		bb = 16;
		
		opacity = 1.0f;
		fade_away = false;
		visible = true;
		solid = true;
		super.Restart();
	}
	
	public void ChangeNPC_ID(int npc_id){
		this.npc_id = npc_id;
		animation.abs_ani_y = 2*npc_id*animation.frame_height;
	}
	
	@Override
	public void Update(Room room){
		fade_time_limit = 30;
		if (fade_away){
			fade_time++;
			if (fade_time%5==0){
				visible = !visible;
			}
			if (fade_time >= fade_time_limit){
				fade_away = false;
				fade_time = 0;
				visible = false;
				solid = false;
			}
		}
		super.Update(room);
	}
	
	public void Speak(Room room, String initiator){
		speaking = true;
		String speech = GetSpeech(room, initiator);
		whatdidisay = speech;
		room.Speak(speech, npc_id, false);
		
		voice = NPC.GetVoice(npc_id);
		ResourceManager.playSound(voice);
	}
	
	public void StopSpeaking(Room room){
		speaking = false;
		room.StopSpeaking();
	}
	
	public void Event(Room room){
		if (npc_id == 0){
			fade_away = true;
			World.num_skulls++;
		}
	}
	
	public String GetSpeech(Room room, String initiator){
		switch (npc_id){
			case 0:
				if (World.num_skulls == 0)
					return Txt.ONE_SKULL;
			case 1:
				return Txt.PoxWartSpeak(initiator);
			case 2:
				return Txt.TreeSpeak(initiator);
			case 3:
				return Txt.CatSpeak(initiator);
			default:
				return "undefined";
		}
	}
}
