package collision;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public abstract class DestroyedBothCollision extends BasicCollisionGroup {

	public void collided(Sprite s1, Sprite s2) {
		s1.setActive(false);
		s2.setActive(false);
		collideEvent(s1, s2);
	}

	public abstract void collideEvent(Sprite s1, Sprite s2);

}
