import java.io.Serializable;

public class pet implements Serializable
{
	String name = "pet";            //名稱
	int    life = 0;                //生命值
	int    attack = 0;              //攻擊力
	int    defend = 0;             	//護盾
	int    speed = 0;				//速度
	double miss = 0 ;               //命中率
	 	
	public pet(String name,int life,int attack,int defend,int speed,double miss)
	{
		
	}
	public int getLife() 
	{
		return life;
	}
	public void setLife(int life)
	{
		this.life = life;
	}
	public int getAttack() 
	{
		return attack;
	}
	public void setAttack(int attack) 
	{
		this.attack = attack;
	}
		public int getDefend() 
	{
		return defend;
	}
	public void setDefend(int defend) 
	{
		this.defend = defend;
	}
	public double getMiss() 
	{
		return miss;
	}
	public void setMiss(double miss) 
	{
		this.miss = miss;
	}
	
	public void fight(int attack) //遭到攻擊時的處理函式
	{
		int hurt = 0;              //受到的傷害
		int residue_life;          //剩餘生命值
		if (die())                 //呼叫下面的陣亡處理函式
		{               
			if(defend!=0)  //對手攻擊力大於自身護盾則受到傷害
			{   
				hurt = attack-defend;
			}
			residue_life = life - hurt;                               //每回合計算剩餘生命值
			System.out.println(this.name+"受到"+hurt+"點傷害！");//列印受到多少傷害
			if(residue_life<0)
				residue_life = 0;
			System.out.println("還剩"+residue_life+"點生命值");          //列印剩餘生命值
			life = residue_life;                                      //當前生命值
		}
	}
	//陣亡時的處理函式，返回一個布林值，代表是否死亡
	public boolean die() 
	{
		boolean flag=true;                     //初始化，代表活著
		if (life <= 0) 
		{                       //生命值小於等於0則陣亡
			System.out.println(this.name+"陣亡");
			flag = false;
		}
		return flag;                           //返回生存狀態
	}
	
	public void dodge()//沒有打中，躲開的處理函式
	{
		System.out.println("沒有擊中，"+this.name+"躲過一劫！");
	}
}