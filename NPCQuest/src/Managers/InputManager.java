package Managers;

import java.awt.event.KeyEvent;

import npcquest.NPCQuest;

import Levels.Room;
import Levels.World;

public class InputManager {
	public static void Update(Room room){
		//DEBUG LEVEL EDITOR
		if (NPCQuest.level_edit){
			if (KeyManager.keys_pressed.containsKey(KeyEvent.VK_PAGE_UP) &&
				KeyManager.keys_down.containsKey(KeyEvent.VK_SHIFT)){
				World.Export();
			}
			if (KeyManager.keys_pressed.containsKey(KeyEvent.VK_PAGE_DOWN) &&
				KeyManager.keys_down.containsKey(KeyEvent.VK_SHIFT)){
				World.ExportWorld();
			}
			
			if (KeyManager.keys_pressed.containsKey(KeyEvent.VK_C)){
				World.ColorCycle();
			}
		}
		
		if (!room.speaking){
			if (KeyManager.keys_pressed.containsKey(KeyManager.START_BUTTON)){
				room.paused = !room.paused;
				if (room.paused){
					room.Speak("Skulls Collected: "+World.num_skulls, 0);
					room.speaking = false;
				}
				else
					room.StopSpeaking();
			}
		}
		if (room.paused) return;
		
		//INTERACTION/TALKING MANAGEMENT
		if (KeyManager.keys_pressed.containsKey(KeyManager.A_BUTTON)){
			room.player.Interact();
		}
		if (KeyManager.keys_pressed.containsKey(KeyManager.B_BUTTON)){
			room.player.Cancel();
		}
		
		if (room.speaking) return;
		//ARROW KEY MANAGEMENT
		if (KeyManager.keys_down.containsKey(KeyManager.RIGHT)){
			room.player.MoveRight();
		}else if (KeyManager.keys_down.containsKey(KeyManager.LEFT)){
			room.player.MoveLeft();
		}
		if (KeyManager.keys_down.containsKey(KeyManager.DOWN)){
			room.player.MoveDown();
		}else if (KeyManager.keys_down.containsKey(KeyManager.UP)){
			room.player.MoveUp();
		}
	}
}
