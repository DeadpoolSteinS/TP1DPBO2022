/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author nichiyo
 */
public class Buku {
    private String img = "";
    private String penerbit = "";
    private String author = "";
    private String desc = "";
    
    public Buku(){};
    
    public Buku(String img, String penerbit, String author, String desc){
        this.img = img;
        this.penerbit = penerbit;
        this.author = author;
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
