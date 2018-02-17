import java.awt.Color;

public class MainRectangles {

	int x;
	int y;
	int width;
	int height;
	Color colorInt;
	public MainRectangles(int x, int y, int width, int height, Color colorInt) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.colorInt = colorInt;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getColorInt() {
		return colorInt;
	}
	public void setColorInt(Color colorInt) {
		this.colorInt = colorInt;
	}
	
	
}
