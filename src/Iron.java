
public class Iron extends Material {
	// Akkor hivodik meg ha asnak az aszteroidan
	public void ReactToMine(Asteroid a, Ceature c) {
		Controller c = new Controller();
		a.SetMaterial(null); // kiszedi az aszteroidabol az eddig bennelevo anyagot, igy ures lesz
		c.AddMaterial(this); //hozzaadja a kibanyaszott anyagot a settler materialjaihoz
	}
	
	public void ReactToSunclose(Asteroid a) {
		// Akkor hivodik meg, ha az aszteroida napkozelben van
		Controller c = new Controller();
	}
	
	public boolean IsEquales(Material m) {
		// ellenorzi, hogy a megadott material ugyanolyan fajta- e, mint az osztaly
		Controller c = new Controller();
		return m.getClass()==this.getClass();
	}
	
}
