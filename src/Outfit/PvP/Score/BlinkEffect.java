package Outfit.PvP.Score;

public class BlinkEffect {
	
	private int i = 1;
	private String texto = "§6§lKOMBO§f§lPVP";
	public BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§f§lKOMBO§6§lPVP";
		}
		if (i == 2){
			texto = "§6§lKOMBO§f§lPVP";
			i = 0;
		}
		i++;
	}
	public String getText(){
	return texto;
	}
}
