import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e com novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem em memória
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("The Best", 150, novaAltura - 100);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
