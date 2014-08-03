package entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Levels.Camera;
import Levels.Room;

public class GameObject {
	public String type;
	public float x;
	public float y;
	public int original_x;
	public int original_y;
	public int lb;
	public int tb;
	public int rb;
	public int bb;
	public int width;
	public int height;
	public boolean delete_me = false;
	public boolean export_me = true;
	public boolean solid = false;
	public int z_index = 0;
	
	public GameObject(float x, float y, int lb, int tb, int rb, int bb){
		type = "GameObject";
		this.x = x;
		this.y = y;
		original_x = (int)x;
		original_y = (int)y;
		this.lb = lb;
		this.tb = tb;
		this.rb = rb;
		this.bb = bb;
		
		width = rb - lb;
		height = bb - tb;
	}
	
	public void ResetPosition(){
		x = original_x;
		y = original_y;
	}
	
	public void Update(Room room){}
	
	public void Render(Graphics2D g2d, Camera camera){}
	
	/****************************COLLISION DETECTION********************/
	public boolean IsColliding(GameObject object){
		return IsRectColliding(object, (int)x+lb, (int)y+tb, (int)x+rb, (int)y+bb);
	}
	
	public boolean IsRectColliding(GameObject object, int lb, int tb, int rb, int bb){
		if (lb <= object.x + object.rb && rb >= object.x + object.lb &&
			tb <= object.y + object.bb && bb >= object.y + object.tb)
			return true;
		return false;
	}
	
	public boolean IsPointColliding(float x, float y){
		if (x <= this.x + rb && x >= this.x + lb &&
				y <= this.y + bb && y >= this.y + tb)
			return true;
		return false;
	}
	
	public ArrayList<GameObject> ReturnCollidingObjects(GameObject[] objects){
		ArrayList<GameObject> colliding_objects = new ArrayList<GameObject>();
		for (int i = 0; i < objects.length; i++){
			if (IsColliding(objects[i])){
				colliding_objects.add(objects[i]);
			}
		}
		return colliding_objects;
	}
}