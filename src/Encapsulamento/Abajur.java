package Encapsulamento;

public class Abajur {
    private int intensidade = 0;
    private boolean ligado = false;


    public Abajur() {
        this.intensidade = 0;
        this.ligado = false;
    }


    private void ligaEDesligaLampada() {
        this.ligado = this.intensidade > 0;
    }

    private int controlaIntensidade() {
        if(this.intensidade == 4) {
            this.intensidade = 0;
        }else {
            this.intensidade += 1;
        }
        return this.intensidade;
    }

    private void DesligaTotalmente() {
        this.intensidade = 0;
        this.ligado = false;
    }

    public void acoes() {
        controlaIntensidade();
        ligaEDesligaLampada();
    }

    public void desligaTudo() {
        DesligaTotalmente();
        System.out.println("A lâmpada foi desligada!");
    }

    public void estaLigada() {
        if(this.ligado) {
            System.out.println("A lâmpada está ligada, com intensidade de: " + this.intensidade);
        }
        else {
            System.out.println("A lâmpada está desligada.");
        }
    }




}
