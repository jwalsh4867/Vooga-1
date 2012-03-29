package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.Timer;

public class Fighter extends Sprite {

	private final int UP = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int RIGHT = 3;
	// private final int FIRE = 4;

	private int healthPoint;
	private int lifeNum;
	private int weaponDamage;
	private int weaponStyle;
	private double speedX, speedY;
	private boolean allowFire = false;
	private Timer refireRate = new Timer(300); // allow to refire after 300 ms
												// (default)
	private BufferedImage bulletImage;

	private double backgroundSpeed;

	public Fighter(BufferedImage image) {
		super(image);
	}

	public void setHP(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getHP() {
		return healthPoint;
	}

	public void setWeapon(int weaponDamage, int weaponStyle) {
		
	}

	public void update(long elapsedTime) {
		super.update(elapsedTime);
	}

	public void fighterControl(long elapsedTime, int key) {
		speedX = this.getHorizontalSpeed();
		speedY = this.getVerticalSpeed();
		switch (key) {
		case UP:
			speedY = -0.3;
			break;
		case DOWN:
			speedY = 0.3;
			break;
		case LEFT:
			speedX = -0.3;
			break;
		case RIGHT:
			speedX = 0.3;
			break;
		}

		// stay relative motionless to the screen
		speedY -= backgroundSpeed;
		setSpeed(speedX, speedY);
	}

	public void fire(long elapsedTime) {
		// try to fire when space key pressed
		if (allowFire == false) {
			allowFire = refireRate.action(elapsedTime);
		}
		if (allowFire) {
			Weapon missile = new Weapon(bulletImage, weaponDamage, weaponStyle);
			// three levels of ammunition
			missile.fire();
		}
	}

	public void setRefireRate(int rate) {
		refireRate = new Timer(rate);
	}

}
