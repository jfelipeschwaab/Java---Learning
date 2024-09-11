package Collections;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Usuario u1 = new Usuario("João", "teste@gmail.com", "joaofsp");
        usuarios.add(u1);

        usuarios.add(new Usuario("Catarina", "atrasada@gmail.com", "atrasada"));
        Usuario u2 = new Usuario("Schwaab", "Alemao@gmail.com", "Alemao");
        usuarios.add(u2);

        System.out.println(usuarios.stream().count());
        System.out.println(usuarios.get(2).nome);

        for (Usuario usuario : usuarios){
            System.out.println(usuario);
        }

        usuarios.remove(0);

        for (Usuario usuario : usuarios){
            System.out.println(usuario);
        }

    }

    //Desafio:
}
