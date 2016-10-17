package bms.player.beatoraja.result;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import bms.player.beatoraja.MainState;
import bms.player.beatoraja.skin.*;

import static bms.player.beatoraja.skin.SkinProperty.*;

public class GradeResultSkin extends Skin {

	private Rectangle gaugeregion;

	private Rectangle judgeregion;

	private final int[] judgecount = { NUMBER_PERFECT, NUMBER_EARLY_PERFECT,
			NUMBER_LATE_PERFECT, NUMBER_GREAT, NUMBER_EARLY_GREAT,
			NUMBER_LATE_GREAT, NUMBER_GOOD,
			NUMBER_EARLY_GOOD,
			NUMBER_LATE_GOOD, NUMBER_BAD, NUMBER_EARLY_BAD,
			NUMBER_LATE_BAD, NUMBER_POOR, NUMBER_EARLY_POOR,
			NUMBER_LATE_POOR, NUMBER_MISS,
			NUMBER_EARLY_MISS,
			NUMBER_LATE_MISS };

	public GradeResultSkin() {
		super(640, 480, 1280, 720);
	}
	
	public GradeResultSkin(Rectangle r) {
		super(1280, 720, r.width, r.height);
		float dw = r.width / 1280.0f;
		float dh = r.height / 720.0f;
		gaugeregion = new Rectangle(20 * dw, 500 * dh, 400 * dw, 200 * dh);
		judgeregion = new Rectangle(500 * dw, 500 * dh, 700 * dw, 200 * dh);

//		SkinImage bgi = new SkinImage(IMAGE_STAGEFILE);
//		setDestination(bgi, 0, 0, 0, 1280, 720, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//		this.add(bgi);
		Texture bg = new Texture("skin/resultbg.png");
		SkinImage image = new SkinImage();
		image.setImage(new TextureRegion[] { new TextureRegion(bg) }, 0);
		setDestination(image, 0, 0, 0, 1280, 720, 0, 255, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		add(image);
		// 数字
		Texture nt = new Texture("skin/number.png");
		TextureRegion[][] ntr = TextureRegion.split(nt, 24, 24);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				addNumber(new SkinNumber(ntr[0], 0, 4, 0, judgecount[i * 3 + j]), 0, 230 + j * 90, 255 - i * 30, 18, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
			}
		}

		Texture cl = new Texture("skin/clear.png");
		SkinImage clear = new SkinImage();
		clear.setImage(TextureRegion.split(cl, 200, 20),0);
		clear.setReferenceID(NUMBER_CLEAR);
		setDestination(clear, 0, 440, 405, 200, 20, 0, 255, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		add(clear);
		SkinImage tclear = new SkinImage();
		tclear.setImage(TextureRegion.split(cl, 200, 20),0);
		tclear.setReferenceID(NUMBER_TARGET_CLEAR);
		setDestination(tclear, 0, 230, 405, 200, 20, 0, 255, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		add(tclear);

		addNumber(new SkinNumber(ntr[0], 0, 4, 0, NUMBER_TOTALEARLY), 0, 320, 75, 18, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		addNumber(new SkinNumber(ntr[0], 0, 4, 0, NUMBER_TOTALLATE), 0, 410, 75, 18, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_HIGHSCORE), 0, 240, 375, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_SCORE), 0, 410, 375, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[1], ntr[2], 0, 5, 0, NUMBER_DIFF_HIGHSCORE), 0, 550, 375, 12, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_TARGET_MISSCOUNT), 0, 240, 345, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_MISSCOUNT), 0, 410, 345, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[1], ntr[2], 0, 5, 0, NUMBER_DIFF_MISSCOUNT), 0, 550, 345, 12, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_TARGET_MAXCOMBO), 0, 240, 315, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_MAXCOMBO), 0, 410, 315, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[1], ntr[2], 0, 5, 0, NUMBER_DIFF_MAXCOMBO), 0, 550, 315, 12, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		SkinNumber dcombo = new SkinNumber(ntr[1], 0, 5, 0);
		setDestination(dcombo, 0, 550, 315, 12, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		dcombo = new SkinNumber(ntr[2], 0, 5, 0);
		setDestination(dcombo, 0, 550, 315, 12, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		addNumber(new SkinNumber(ntr[0], 0, 5, 0, NUMBER_TOTALNOTES), 0, 360, 486, 12, 12, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);

//		SkinText title = new SkinText("skin/VL-Gothic-Regular.ttf",0,24, 2);
//		title.setReferenceID(STRING_FULLTITLE);
//		title.setAlign(SkinText.ALIGN_CENTER);
//		setDestination(title, 0, 640, 23, 24, 24, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//		this.add(title);

		add(new SkinGaugeGraphObject());
		add(new SkinDetailGraphObject());

		Texture st = new Texture("skin/system.png");
		SkinImage fi = new SkinImage(new TextureRegion[]{new TextureRegion(st,8,0,8,8)},0);
        setDestination(fi, 0, 0, 0,1280, 720, 0, 0,255,255,255, 0, 0, 0, 0, 500, TIMER_FADEOUT, 0, 0, 0);
        setDestination(fi, 500, 0, 0,1280, 720, 0, 255,255,255,255, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        add(fi);

        setFadeout(500);
        setScene(3600000 * 24);
        setInput(500);
	}

	public void setGaugeRegion(Rectangle region) {
		gaugeregion = region;
	}

	public Rectangle getGaugeRegion() {
		return gaugeregion;
	}

	public Rectangle getJudgeRegion() {
		return judgeregion;
	}

	public static class SkinGaugeGraphObject extends SkinObject {

		@Override
		public void draw(SpriteBatch sprite, long time, MainState state) {
			sprite.end();
			if(state instanceof MusicResult) {
				((MusicResult)state).renderGraph(time);
			}
			if(state instanceof GradeResult) {
				((GradeResult)state).renderGraph(time);
			}
			sprite.begin();
		}

		@Override
		public void dispose() {

		}
	}

	public static class SkinDetailGraphObject extends SkinObject {

		@Override
		public void draw(SpriteBatch sprite, long time, MainState state) {
			sprite.end();
			if(state instanceof MusicResult) {
				((MusicResult)state).renderDetail(time);
			}
			sprite.begin();
		}

		@Override
		public void dispose() {

		}
	}


}
