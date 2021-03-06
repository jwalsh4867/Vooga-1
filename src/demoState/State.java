package demoState;

import game.TopDownGameEngine;
import game.TopDownGameObject;

import java.awt.Graphics2D;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

public abstract class State extends TopDownGameObject {
	public boolean levelComplete = false;
    public boolean gameOver = false;
    public int gameID;
    
	public State(TopDownGameEngine parent) {
		super(parent);
	}

	public abstract void initResources();

	public abstract void update(long elapsedTime);

	public abstract void render(Graphics2D g);

	public abstract boolean levelComplete();

//	public int getLevel(){
//		return gameID;
//	}
}