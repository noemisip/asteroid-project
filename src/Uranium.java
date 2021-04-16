
public class Uranium  extends Material {

	private int cnt = 0;

	// Akkor hivodik meg ha asnak az aszteroidan
	public void ReactToMine(Asteroid a, Creature c) {
		a.SetMaterial(null); // kiszedi az aszteroidabol az eddig bennelevo anyagot, igy ures lesz
		c.AddMaterial(this); //hozzaadja a kibanyaszott anyagot a settler materialjaihoz
	}

	public void ReactToSunclose(Asteroid a) {
		// Akkor hivodik meg, ha az aszteroida napkozelben van
		if(cnt < 2)
			SetCnt(1);
		if(cnt == 2)
			a.Explosion();
	}

	public boolean IsEquales(Material m) {
		// ellenorzi, hogy a megadott material ugyanolyan fajta- e, mint az osztaly
		return m.getClass()==this.getClass();
	}

	void SetCnt(int cnt) {
		this.cnt -= cnt;
	}

	int GetCnt() {
		return cnt;
	}

}
