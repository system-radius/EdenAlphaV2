package com.systemphoenix.edenalpha;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class MainScreen extends AbsoluteScreen {

    private Texture bg;
    private String loadingMessage = "Loading...";
    private GlyphLayout glyphLayout;

    private boolean canStart = false, blinking = true;
    private long blink;

    public MainScreen(EdenAlpha game) {
        super(game);
        this.font.getData().setScale(1.5f);
        this.font.setColor(Color.BLACK);
        this.glyphLayout = new GlyphLayout();
        this.bg = new Texture(Gdx.files.internal("bg.jpg"));
    }

    public void update() {
        if(blinking) {
            if(TimeUtils.timeSinceMillis(blink) >= 800) {
                blinking = false;
                blink = TimeUtils.millis();
            }
        } else {
            if(TimeUtils.timeSinceMillis(blink) >= 500) {
                blink = TimeUtils.millis();
                blinking = true;
            }
        }
    }

    @Override
    public void render(float delta) {
        if(canStart) {
            update();
        }

        glyphLayout.setText(font, loadingMessage);
        float x = (screenWidth - glyphLayout.width) / 2;
        gameGraphics.begin();
        gameGraphics.draw(bg, 0, 0, screenWidth, screenHeight);
        if(canStart) {
            if(blinking) {
                font.draw(gameGraphics, loadingMessage, x, screenHeight / 4 - screenHeight / 16);
            }
        } else {
            font.draw(gameGraphics, loadingMessage, x, screenHeight / 4 - screenHeight / 16);
        }
        gameGraphics.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if(canStart) game.setScreenToMapScreen();
        return true;
    }

    public void setLoadingMessage(String loadingMessage) {
        this.loadingMessage = loadingMessage;
    }

    public void setCanStart(boolean canStart) {
        this.canStart = canStart;
    }
}