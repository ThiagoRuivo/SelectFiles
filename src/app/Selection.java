
package app;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Selection {
  /*
    Campos
  */
  public final int TEXTO = 0;
  public final int EXECUTAVEL = 1;
  public final int PDF = 2;
  public final int WORD2003 = 3;
  public final int WORD = 4;
  public final int EXCEL2003 = 5;
  public final int EXCEL = 6;
  public final int POWERPOINT2003 = 7;
  public final int POWERPOINT = 8;
  public final int JPG = 9;
  public final int JPEG = 10;
  public final int PNG = 11;
  public final int BITMAP = 12;
  public final int GIF = 13;
  public final int MP3 = 14;
  public final int WAV = 15;
  public final int WMA = 16;
  public final int MP4 = 17;
  public final int AVI = 18;
  public final int MPG = 19;
  public final int MOV = 20;
  public final int PHOTOSHOP = 21;
  public final int CORELDRAW = 22;
  public final int ILLUSTRATOR = 23;
  public final int VETO = 24;
  public final int AUTOCAD  = 25;
  public final int BIBLIOTECAS = 26;
  public final int JAVA = 27;
  public final int VBNET = 28;
  public final int CSHARP = 29;
  public final int C = 30;
  public final int H = 31;
  public final int HTML = 32;
  public final int CSS = 33;
  public final int JS = 34;
  public final int JSON = 35;
  public final int SQL = 36;
  public final int XML = 37;
  public final int PHP = 38;
  private final String[][] extensaoArquivos;
  private String mainPath;
  private String ultimoDiretorio;
  
  /*
    Construtores
  */
  public Selection() {
    this.mainPath = "C:\\";
    this.extensaoArquivos = extArquivos();
    this.ultimoDiretorio = "";
  }
  
  /*
    Get's & Set's
  */
  public String getMainPath() {
    return mainPath;
  }
  public void setMainPath(String mainPath) {
    this.mainPath = mainPath;
  }
  public String getUltimoDiretorio() {
    return ultimoDiretorio;
  }
  public void setUltimoDiretorio(String ultimoDiretorio) {
    this.ultimoDiretorio = ultimoDiretorio;
  }
  public String[][] getExtensaoArquivos() {
    return extensaoArquivos;
  }
  
  /*
    Demais métodos
  */
  private String[][] extArquivos () {
    String[] desc = new String[] {
      "Arquivo texto .txt",
      "Executáveis .exe",
      "Adobe acrobat .pdf",
      "Documento Word 97-2003 .doc",
      "Documento Word .docx",
      "Planilha Excel 97-2003 .xls",
      "Planilha Excel .xlsx",
      "Apresentação PowerPoint 97-2003 .ppt",
      "Apresentação PowerPoint .pptx",
      "Imagem .jpg",
      "Imagem .jpeg",
      "Imagem .png",
      "Bitmap .pbm",
      "Animação .gif",
      "Audio .mp3",
      "Audio .wav",
      "Audio .wma",
      "Video .mp4",
      "Video .avi",
      "Video .mpg",
      "Video .mov",
      "Photoshop .psd",
      "Coreldraw .cdr",
      "Illustrator .ai",
      "Vetor .eps",
      "AutoCad .dwg",
      "Bibliotecas .dll",
      "Programação JAVA .java",
      "Programação VB.NET .vb",
      "Programação C# .csharp",
      "Programação C .c",
      "Programação H .h",
      "Programação HTML .html",
      "Programação CSS .css",
      "Programação JS .js",
      "Programação JSON .json",
      "Programação SQL .sql",
      "Programação XML .xml",
      "Programação PHP .php"
    };
    String[] ext = new String[] {
      "txt",
      "exe",
      "pdf",
      "doc",
      "docx",
      "xls",
      "xlsx",
      "ppt",
      "pptx",
      "jpg",
      "jpeg",
      "png",
      "pbm",
      "gif",
      "mp3",
      "wav",
      "wma",
      "mp4",
      "avi",
      "mpg",
      "mov",
      "psd",
      "cdr",
      "ai",
      "eps",
      "dwg",
      "dll",
      "java",
      "vb",
      "csharp",
      "c",
      "h",
      "html",
      "css",
      "js",
      "json",
      "sql",
      "xml",
      "php"
    };
    String[][] mat = new String[][] {
      desc, ext
    };
    return mat;
  }
  public File unicoArquivo () {
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      this.ultimoDiretorio = sela.getSelectedFile().getAbsolutePath();
      return sela.getSelectedFile();
    } else {
      return null;
    }
  }
  public File unicoArquivo (int tipoArquivo) {
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.FILES_ONLY);
    if ((tipoArquivo >= 0) && (tipoArquivo <= 38)) {
      sela.setFileFilter(new FileNameExtensionFilter(this.extensaoArquivos[0][tipoArquivo], this.extensaoArquivos[1][tipoArquivo]));
    } else {
      JOptionPane.showMessageDialog(null, "Para selecionar um único arquivo informe um número maior que zero e menor que 38."
              + "\nClass Selection, function unicoArquivo.\ntipoArquivo = " + tipoArquivo);
      return null;
    }
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      this.ultimoDiretorio = sela.getSelectedFile().getAbsolutePath();
      return sela.getSelectedFile();
    } else {
      return null;
    }
  }
  public File unicoArquivo (String descArquivo, String extArquivo) {
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.FILES_ONLY);
    if ((!"".equals(descArquivo)) && (!"".equals(extArquivo))) {
      sela.setFileFilter(new FileNameExtensionFilter(descArquivo, extArquivo));
    } else {
      JOptionPane.showMessageDialog(null, "Para selecionar um arquivo informe uma descrição para o tipo de arquivo e sua extensão"
              + "\nClass Selection, function unicoArquivo."
              + "\nDescrição do arquivo = " + descArquivo
              + "\nExtensão do arquivo = " + extArquivo);
      return null;
    }
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      this.ultimoDiretorio = sela.getSelectedFile().getAbsolutePath();
      return sela.getSelectedFile();
    } else {
      return null;
    }
  }
  public File[] variosArquivos () {
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.FILES_ONLY);
    sela.setMultiSelectionEnabled(true);
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      this.ultimoDiretorio = sela.getSelectedFiles()[0].getAbsolutePath();
      return sela.getSelectedFiles();
    } else {
      return null;
    }
  }
  public File[] variosArquivos (int tipoArquivo) {
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.FILES_ONLY);
    sela.setMultiSelectionEnabled(true);
    if ((tipoArquivo >= 0) && (tipoArquivo <= 38)) {
      sela.setFileFilter(new FileNameExtensionFilter(this.extensaoArquivos[0][tipoArquivo], this.extensaoArquivos[1][tipoArquivo]));
    } else {
      JOptionPane.showMessageDialog(null, "Para selecionar vários arquivos informe um número maior que zero e menor que 38."
              + "\nClass Selection, function variosArquivos.\ntipoArquivo = " + tipoArquivo);
      return null;
    }
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      this.ultimoDiretorio = sela.getSelectedFiles()[0].getAbsolutePath();
      return sela.getSelectedFiles();
    } else {
      return null;
    }
  }
  public File[] variosArquivos (String descArquivo, String extArquivo) {
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.FILES_ONLY);
    sela.setMultiSelectionEnabled(true);
    if ((!"".equals(descArquivo)) && (!"".equals(extArquivo))) {
      sela.setFileFilter(new FileNameExtensionFilter(descArquivo, extArquivo));
    } else {
      JOptionPane.showMessageDialog(null, "Para selecionar vários arquivos informe uma descrição para o tipo de arquivo e sua extensão"
              + "\nClass Selection, function variosArquivos."
              + "\nDescrição do arquivo = " + descArquivo
              + "\nExtensão do arquivo = " + extArquivo);
      return null;
    }
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      this.ultimoDiretorio = sela.getSelectedFiles()[0].getAbsolutePath();
      return sela.getSelectedFiles();
    } else {
      return null;
    }
  }
  public String diretorio () {
    String retorno = new String();
    JFileChooser sela = new JFileChooser(this.mainPath);
    sela.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int resposta = sela.showOpenDialog(null);
    if (resposta == JFileChooser.APPROVE_OPTION) {
      retorno = sela.getSelectedFile().getAbsolutePath();
      this.ultimoDiretorio = sela.getSelectedFile().getAbsolutePath();
      return retorno;
    } else {
      return retorno;
    }
  }
}
