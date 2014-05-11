package view;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import model.items.*;
import model.board.Cell;
import model.board.Content;
import model.element.Valuable;
import model.fighter.*;
import model.fighter.hero.HeroArmoredImp;
import model.fighter.hero.HeroImp;
import model.fighter.hero.HeroSwordedImp;
import model.fighter.enemies.*;


public class ImageManager {
	
	private Map<String, Image> images = new HashMap<String, Image>();
	
	public ImageManager() {
		initImages();
	}

	public void initImages() { 
		try{
			
			images.put(Cell.class.getName(), ImageUtils.loadImage("resources/floor.png"));
			
			images.put(BonusStrength.class.getName(), ImageUtils.loadImage("resources/attackbonus.png"));
			images.put(BloodSplash.class.getName(), ImageUtils.loadImage("resources/blood.png"));
			images.put(Goblin.class.getName(), ImageUtils.loadImage("resources/goblin.png"));
			images.put(Golem.class.getName(), ImageUtils.loadImage("resources/golem.png"));
			images.put(Potion.class.getName(), ImageUtils.loadImage("resources/healthPotion.png"));
			images.put(Health.class.getName(), ImageUtils.loadImage("resources/healthbonus.png"));
			images.put(HeroArmoredImp.class.getName(), ImageUtils.loadImage("resources/heroArmor.png"));
			images.put(Snake.class.getName(), ImageUtils.loadImage("resources/Serpent.png"));
			images.put(Sword.class.getName(), ImageUtils.loadImage("resources/sword.png"));
			images.put(Wall.class.getName(), ImageUtils.loadImage("resources/wall.png"));
			
			
			
			images.put(HeroImp.class.getName(), ImageUtils.loadImage("resources/heroBase.png"));
			images.put(Armor.class.getName(), ImageUtils.loadImage("resources/armor.png"));
			images.put(HeroSwordedImp.class.getName(), ImageUtils.loadImage("resources/heroBase.png"));
						
			images.put("FOG", ImageUtils.loadImage("resources/fog.png"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Image get(Cell cell) {
		if (cell.hasContent()) {
			Content content = cell.getContent();
			if (content instanceof Fighter) {
				Fighter fighter = (Fighter) content;
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(fighter.getClass().getName()));
				return ImageUtils.drawString(image, String.valueOf(fighter.getLevel()), Color.YELLOW);
			} else {
			{
				Image image= ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(content.getClass().getName()));
				
				if(content instanceof Valuable)
				{
					Valuable element=(Valuable) content;
					image=ImageUtils.drawString(image, String.valueOf(element.getValue()), Color.YELLOW);
				}
				return image;
				
			}
				
			}
		} else {
			return images.get(cell.getClass().getName());
		}
		
	}
	
	public Image get(String key) {
		return images.get(key);
	}
}
