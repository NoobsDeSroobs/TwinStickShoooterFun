package system;

import graphics.Sprite;

public class Screen {

	public int width, height;
	public int[] pixels;

	private int xOffset;
	private int yOffset;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.getYSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getXSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getXSIZE() || xa >= width
						|| ya < -sprite.getYSIZE() || ya >= height) {
					break;
				}
				if (xa < 0) {
					xa = 0;
				}
				if (ya < 0) {
					ya = 0;
				}
				pixels[xa + ya * width] = sprite.pixels[x + y
						* sprite.getXSIZE()];
			}
		}
	}

	public void renderWithoutMask(int xp, int yp, Sprite sprite, boolean locked) {
		if (!locked) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.getYSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getXSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getXSIZE() || xa >= width
						|| ya < -sprite.getYSIZE() || ya >= height) {
					break;
				}
				if (xa < 0) {
					xa = 0;
				}
				if (ya < 0) {
					ya = 0;
				}
				pixels[xa + ya * width] = sprite.pixels[x + y
						* sprite.getXSIZE()];
			}
		}
	}

	public void renderWithMask(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.getYSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getXSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getXSIZE() || xa >= width
						|| ya < -sprite.getYSIZE() || ya >= height) {
					break;
				}
				if (xa < 0) {
					xa = 0;
				}
				if (ya < 0) {
					ya = 0;
				}
				int col = sprite.pixels[x + y * sprite.getXSIZE()];
				if (col != 0xFFFF00FF) {
					pixels[xa + ya * width] = col;
				}
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void renderSquare(int xp, int yp, boolean locked, Sprite sprite) {

		if (!locked) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.getYSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getXSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getXSIZE() || xa >= width
						|| ya < -sprite.getYSIZE() || ya >= height) {
					break;
				}
				if (xa < 0) {
					xa = 0;
				}
				if (ya < 0) {
					ya = 0;
				}

				pixels[xa + ya * width] = sprite.pixels[x + y
						* sprite.getXSIZE()];
			}
		}
	}
}