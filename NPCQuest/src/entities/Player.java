package entities;

import entities.helpers.Txt;
import Levels.Room;
import Levels.World;
import Managers.ResourceManager;

public class Player extends NPC{
	private boolean try_interact = false;
	
	public Player(float x, float y){
		super(x, y, 0, "", "player_sheet");
		type = "Player";
		facing = UP;
		whatdidisay = Txt.ELLIPSE;
	}
	
	@Override
	public void Update(Room room){
		if (try_interact){
			int q = 8;
			for (int i = 0; i < room.entities.size(); i++){
				if (room.entities.get(i).type.equals("NPC")){
					if (IsRectColliding(room.entities.get(i),
						(int)Math.round(x+lb-q), (int)Math.round(y+tb-q), 
						(int)Math.round(x+rb+q), (int)Math.round(y+bb+q))){
	
						NPC npc = (NPC)room.entities.get(i);
						if (!npc.visible || npc.fade_away) break;
						if (npc.speaking){
							if (World.num_skulls >= 1){
								whatdidisay = npc.whatdidisay;
								voice = npc.voice;
							}
							npc.StopSpeaking(room);
							npc.Event(room);
							//ChangeNPC_ID(npc.npc_id);
						}else if (speaking){
							StopSpeaking(room);
							npc.Speak(room, whatdidisay);
						}else{
							Speak(room);
						}
	
						try_interact = false;
						break;
					}
				}
			}
			
			if (try_interact){
				if (speaking){
					StopSpeaking(room);
				}else{
					Speak(room);
				}
				try_interact = false;
			}
		}
		
		super.Update(room);
	}
	
	public void Speak(Room room){
		speaking = true;
		room.Speak(whatdidisay, npc_id, true);

		ResourceManager.playSound(voice);
	}
	
	public void Interact(){
		try_interact = true;
	}
	
	public void Cancel(){
		if (!whatdidisay.equals(Txt.ELLIPSE))
			ResourceManager.playSound("forget");
		whatdidisay = Txt.ELLIPSE;
		voice = "";
		ChangeNPC_ID(0);
	}
}
