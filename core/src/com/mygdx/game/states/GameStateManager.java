package com.mygdx.game.states;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
    }

    public void pop() {
        states.pop();
    }

    public void set(State state) {
        states.pop();
        states.push(state);
    }
    
    public void create(){
    	states.peek().create();
    }
    
    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
    public void dispose() {
    	states.peek().dispose();
    }
    
    public void resize(int width, int height) {
    	states.peek().resize(width,height);
    }
    
    public void setProjectionMatrix(SpriteBatch sb) {
    	states.peek().setProjectionMatrix(sb);
    }
    
    
    
}
