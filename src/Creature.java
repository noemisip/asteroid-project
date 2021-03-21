import java.util.ArrayList;

public abstract class Creature {
	protected Asteroid asteroid; //az az aszteroida amin a creautre éppen áll

	public abstract void Die(); //a creature meghal
	public void Drill() { //a creature fúr az aszteroida köpenyén
		Controller c = new Controller();
		c.SetTab(1);
		c.PrintFunc("Drill()");

		asteroid.DecreaseLayer();
		c.SetTab(-1);
	}

	public abstract void Move(Asteroid a); //a creature a kiválasztott aszteroidára mozog
	
	public abstract void AsteroidExplosion(); //a creature reagál az aszteroida robbanására
	
	public void SetAsteroid(Asteroid a) { //a creature asteroid attruibutumának értékét állítja be
		Controller c = new Controller();
		c.SetTab(1);
		c.PrintFunc("SetAsteroid(a)");

		asteroid=a;
		c.SetTab(-1);
	}
	
	public abstract ArrayList<Material> GetMaterials(); //visszaadja a creaturenél lévő nyersanyagok listáját
}
