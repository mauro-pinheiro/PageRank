package pagerank;


import pagerank.entidade.Page;

import javax.persistence.Persistence;

public class Main {
    //Pagina a linka a pagina b
    public static void Linka(Page a, Page b){
        a.addLinkPara(b);
        b.addLinkDe(a);
    }

    public static void main(String[] args) {
        Page A = new Page();
        Page B = new Page();
        Page C = new Page();
        Page D = new Page();

        Linka(A,B);
        Linka(A,C);
        Linka(B,D);
        Linka(C,A);
        Linka(C,B);
        Linka(C,D);
        Linka(D,C);

        for(int i = 0; i < 2; i++){
            A.calculaRank();
            B.calculaRank();
            C.calculaRank();
            D.calculaRank();
            A.atualizaRank();
            B.atualizaRank();
            C.atualizaRank();
            D.atualizaRank();
        }

        System.out.println("Rank A = " + A.getRank());
        System.out.println("Rank B = " + B.getRank());
        System.out.println("Rank C = " + C.getRank());
        System.out.println("Rank D = " + D.getRank());
    }
}
