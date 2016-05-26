package br.com.ana.rob

import br.com.rob.ana.sempre.Aula

public class Download {

    public void baixar(Aula aula) {

        try{

            URL url = null;
            URLConnection conn = null;

            File file = new File(aula.curso.nome + "/" + aula.nome);
            file.mkdirs()

            File fileAula = new File(file.path + File.separator + aula.nomeVideo + ".mp4");

            OutputStream out = new FileOutputStream(fileAula, false);
            url = new URL(aula.video);
            conn = url.openConnection();

            InputStream input = conn.getInputStream();

            int i=0;
            while ((i = input.read()) != -1){
                out.write(i);
            }
            input.close();
            out.close();

            aula.baixado = true

            aula.save(flush: true)

            System.out.println("Gravação efetuada com sucesso " + aula);


        }

        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado. Causa: " + e.getMessage());
        }
        catch (MalformedURLException e){
            System.out.println("Erro na formação da URL. Causa: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("Erro de entrada/saida de dados. Causa: " + e.getMessage());
        }

    }

}
