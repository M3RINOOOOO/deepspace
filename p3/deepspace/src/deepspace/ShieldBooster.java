/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author cristobalmer
 */
class ShieldBooster {
    private String name;
    private float boost;
    private int uses;
    
    ShieldBooster(String _name,float _boost,int _uses){
        name = _name;
        boost = _boost;
        uses = _uses;
    }
    ShieldBooster(ShieldBooster s){
        name = s.name;
        boost = s.boost;
        uses = s.uses;
    }
    public String getName(){
        return name;
    }    
    public float getBoost(){
        return boost;
    }
    public int getUses(){
        if (uses!=-1)
            return uses;
        else return 0;
    }
    public float useIt(){
        if(uses>0){
            uses--;
            return boost;
        }else return 1.0f;
    }
    ShieldToUI getUIVersion(){
       return new ShieldToUI(this);
    }
    
    @Override
    public String toString(){
        String result= new String("Name of shieldbooster: ");
        result+=name+"\nBoost: "+String.valueOf(boost)+"\nNumber of uses: "+String.valueOf(uses);
        return result;
    }
}
