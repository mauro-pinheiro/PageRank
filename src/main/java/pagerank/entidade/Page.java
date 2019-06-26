package pagerank.entidade;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Page {

    private String conteudo;
    private Set<Page> linka = new LinkedHashSet<>();

    private Set<Page> linkado = new LinkedHashSet<>();

    private Float rank = 1.0f;

    private Float novoRank = 1.0f;

    public String getConteudo(){
        return conteudo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public void addLinkPara(Page p){
        linka.add(p);
    }

    public void addLinkDe(Page p){
        linkado.add(p);
    }

    public Integer getNumLinksPara(){
        return linka.size();
    }

    public Float calculaRank(){
        float temp = linkado.stream()
                .map(page -> page.getRank()/page.getNumLinksPara())
                .reduce(0.0f, (a,b) -> a + b);
        if(temp != 0)
            novoRank = 0.15f + 0.85f*(temp);
        return novoRank;
    }

    public Float getRank(){
        return rank;
    }

    public void atualizaRank(){
        rank = novoRank;
    }
}
