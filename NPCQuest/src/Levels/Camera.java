package Levels;

import npcquest.NPCQuest;

public class Camera {
	public float x = 0;
	public float y = 0;
	public int width;
	public int height;
	public int screen_offset_x = 0;
	public int screen_offset_y = 0;
	public int x_lim = 100;
	public int y_lim = 100;
	public boolean instant = true;
	public float speed = 1.5f;
	
	public Camera(){
		width = NPCQuest.GAME_WIDTH;
		height = NPCQuest.GAME_HEIGHT;
	}
	
	public void Update(Room room){
		//Horizontal Panning RIGHT
		if (room.player.x + room.player.rb + x_lim - x >= width){
			if (x < room.MAP_WIDTH * Tile.WIDTH - width){
				if (instant){
					x = room.player.x + room.player.rb + x_lim - width;
				}else{
					x += speed;
				}
				
				if (x >= room.MAP_WIDTH * Tile.WIDTH - width)
					x = room.MAP_WIDTH * Tile.WIDTH - width;
			}
		}
		//Horizontal Panning LEFT
		if (room.player.x + room.player.lb - x_lim - x <= 0){
			if (x > 0){
				if (instant){
					x = room.player.x + room.player.lb - x_lim;
				}else{
					x -= speed;
				}
				
				if (x <= 0) 
					x = 0;
			}
		}
		
		//Vertical panning DOWN
		if (room.player.y + room.player.bb + y_lim - y >= height){
			if (y < room.MAP_HEIGHT * Tile.HEIGHT - height){
				if (instant){
					y = (room.player.y + room.player.bb + y_lim);
				}else{
					y += speed;
				}
				
				if (y >= room.MAP_HEIGHT * Tile.HEIGHT - height)
					y = room.MAP_HEIGHT * Tile.HEIGHT - height;
			}
		}
		//Vertical panning UP
		if (room.player.y + room.player.tb - y_lim - y <= 0){
			if (y > 0){
				if (instant){
					y = room.player.y + room.player.tb - y_lim;
				}else{
					y -= speed;
				}
			}
		}
	}
}
