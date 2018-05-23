
/**
 * Escreva a descrição da classe CIndividual aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class CIndividual extends Contribuinte implements Serializable
{
    private int n_agregado;
    private Set<Integer> nifs_agregado;
    private double coeficientefiscal;
    private Set<String> setores;
    
    /**
     * Contrutor sem argumentos da classe CIndividual.
     */
    
    public CIndividual(){
        super();
        this.n_agregado = -1;
        this.nifs_agregado = new HashSet<Integer>();
        this.coeficientefiscal = -1;
        this.setores = new HashSet<String>();
    }
    /**
      * Construtor com argumentos.
      * @param nif1         Nif a introduzir.
      * @param nemail       Email a introduzir.
      * @param nnome        Nome a introduzir.
      * @param nmorada      Morada a introduzir.
      * @param npassword    Password a introduzir.
      * @param nn_agregado  Número de elementos no agregado.
      * @param agregados    Conjunto com os nifs dos agredados.
      * @param ncoefiente   Coeficiente de dedução.
      * @param nsetores     Conjunto de setores em que pode haver descontos.
    */
    
    public CIndividual(int nif1,String nemail,String nnome,String nmorada,String npassword,int nn_agregado,Set<Integer> agregados,double ncoeficiente,Set<String> nsetores,Set<Integer> faturas){
        super(nif1,nemail,nnome,nmorada,npassword,faturas);
        this.n_agregado = nn_agregado;
        setNifs_agregado(agregados);
        this.coeficientefiscal = ncoeficiente;
        setSetores(nsetores);
    }
    
    public CIndividual(CIndividual c){
        super(c);
        this.n_agregado = c.getNumAgregado();
        this.nifs_agregado = c.getNifsAgregado();
        this.coeficientefiscal = c.getCoeficientefiscal();
        this.setores = c.getSetores();
    }
    
    /**
     * Método que devolve o número de elementos no agregado familiar.
     */
    
    public int getNumAgregado(){
        return this.n_agregado;
    }
    
    /**
     * Set que altera o valor do número de elementos no agregado.
     */
    
    public void setNumAgregado(int a){
        this.n_agregado = a;
    }
    
    /**
     * Método que devolve o valor do coeficiente fiscal.
     */
    
    public double getCoeficientefiscal(){
        return this.coeficientefiscal;
    }
    /**
     * Set que altera o valor do coeficiente fiscal.
     * @param a     Valor a inserir.
     */
    
    public void setCoeficientefiscal(double a){
        this.coeficientefiscal = a;
    }
    
    /**
     * Método que copia um set de inteiros para o set com os nifs dos agregados familiares.
     * @param agregados Set a copiar.
     */
    
    public void setNifs_agregado(Set<Integer> agregados){
        this.nifs_agregado = new HashSet<Integer>();
        Iterator <Integer> i = agregados.iterator();
        int aux;
        
        while(i.hasNext()){
            aux = i.next();
            this.nifs_agregado.add(aux);
        }
    }
    
    /**
     * Método que copia um set de String para o set com os setores de dedução.
     * @param agregados Set a copiar.
     */
    
    public void setSetores(Set<String> setores){
        this.setores = new HashSet<String>();
        Iterator <String> i = setores.iterator();
        String aux;
        
        while(i.hasNext()){
            aux = i.next();
            this.setores.add(aux);
        }
        
    }
    
    /**
     * Método que devolve uma cópia do conjunto de setores
     */
    
    public Set<String> getSetores(){
        Set<String> nconj = new HashSet<String>();
        Iterator <String> i = this.setores.iterator();
        String aux;
        
        while(i.hasNext()){
            aux = i.next();
            nconj.add(aux);
        }
        
        return nconj;
    }
    
    /**
     * Método que devolve uma cópia do conjunto de nifs do agregado.
     */
    
    public Set<Integer> getNifsAgregado(){
        Set<Integer> nconj = new HashSet<Integer>();
        Iterator <Integer> i = this.nifs_agregado.iterator();
        int aux;
        
        while(i.hasNext()){
            aux = i.next();
            nconj.add(aux);
        }
        
        return nconj;
    }
    
    /**
     * Método que produz um clone do objeto.
     */
    
    public CIndividual clone(){
        return new CIndividual(this);
    }
    
    /**
     * Método toString.
     */
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        
        sb.append(super.toString());
        sb.append("Nº elementos no agregado: ");
        sb.append(this.n_agregado +"\n");
        sb.append("Nif dos agregados: ");
        for(int a : this.nifs_agregado){
            sb.append(a + "; ");
        }
        sb.append("\n");
        sb.append("Coeficiente Fiscal: ");
        sb.append(this.coeficientefiscal + "\n");
        sb.append("Setores de dedução: ");
        
        for(String b : this.setores)
            sb.append(b + "; ");
        sb.append("\n");
        
        return sb.toString();
    }
    
    /**
     * Método equals da classe CIndividual
     */
    
    public boolean equals(Object o){
        if(this == o)
            return true;
        
        if (o == null || (this.getClass() != o.getClass()))
            return false;
            
        CIndividual aux = (CIndividual) o;
        
        return super.equals(aux)
            && this.n_agregado == aux.getNumAgregado()
            && this.coeficientefiscal == aux.getCoeficientefiscal()
            && this.nifs_agregado.equals(aux.getNifsAgregado())
            && this.setores.equals(aux.getSetores());
        
    }
    
    public int hashCode(){
        int hash = 7;
        long aux;
        
        aux = Double.doubleToLongBits(this.coeficientefiscal);
        hash = hash*31 + super.hashCode();
        hash = hash*31 + this.n_agregado;
        hash = hash*31 + this.nifs_agregado.hashCode();
        hash = hash*31 + this.setores.hashCode();
        hash = 31*hash + (int)(aux^(aux >>> 32));
        
        
        
        return hash;
    }
    
    
    
}
