package view.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Game;
import model.board.Cell;
import model.board.Content;
import model.fighter.Fighter;
import model.fighter.enemies.Enemy;
import view.ImageManager;

public class InfoPanel extends JPanel implements GamePanelListener {
	private static final long serialVersionUID = 1L;
	
	private HeroPanel heroPanel;
	private FighterPanel enemyPanel;
	private Game game;
	
	public InfoPanel(Game game, ImageManager imgManager, int width, int height) {
		this.game = game;
		setBackground(Color.GRAY);
		setBounds(height, 1, width, height);
		setLayout(new FlowLayout());
		heroPanel = new HeroPanel(Color.WHITE, game.getHero(), imgManager);
		heroPanel.setVisible(true);
		add(heroPanel);
		enemyPanel = new FighterPanel(Color.WHITE, game.getHero(), imgManager);
		add(enemyPanel);
		refresh();
	}
	
	public void refresh(){
		heroPanel.setFighter(game.getHero());
		heroPanel.refreshData();
		enemyPanel.refreshData();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (game.isOver()) {
			Font plain=new Font("Arial", Font.BOLD, 12);
			g.setFont(plain);
			if (game.playerWon()) {
				g.drawString("Stage Over - Player WON !!!", 10, 140);
				game.nextLevel();
			} else {
				g.drawString("Game Over - Player DIED !!!", 10, 140);
			}
		
		}
	}
	
	@Override
	public void onMouseOver(int row, int column) {
		Cell cell =game.get(row,column);
		
		if(cell.hasFog())
			return;
		
		Content content = cell.getContent();
				
		if (content != null && content instanceof Enemy) {
			enemyPanel.setVisible(true);
			enemyPanel.setFighter((Fighter)content);
		} else {
			enemyPanel.setVisible(false);

		}
		refresh();
	}
	
}
