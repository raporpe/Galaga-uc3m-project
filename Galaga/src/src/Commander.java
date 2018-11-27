package src;

public class Commander extends Enemy{
	private String imgPath="enemy100.png";
	public Commander(){
		super();
		this.imgPath = getImgPath();
	}
}
