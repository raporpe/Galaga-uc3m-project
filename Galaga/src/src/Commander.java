package src;

public class Commander extends Enemy{
	private String imgPath="enemy100.png";
	public Commander(int id){
		super();
		this.imgPath = getImgPath();
	}
}
