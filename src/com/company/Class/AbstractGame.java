package com.company.Class;

import com.company.engine.GameContainer;

public abstract class AbstractGame {
    public abstract void update(GameContainer gameContainer, float dt);
    public abstract void render(GameContainer gameContainer, Renderer renderer);


}
