
package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JPanelImage extends javax.swing.JPanel {
    // ������ 2 �����������: ������������ � �������.
    // ������������ ������������ ��� ��������� �������� � ����������� �� �������� ������.
    // ������� ��������������� ��������������� �� ������.

    private BufferedImage originalImage = null;
    private Image image = null;

    public JPanelImage() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                fromComponentResized(e);
            }
        });
    }

    // ������� �� ��������� �������� ������ - ��������� ������� �����������.
    private void fromComponentResized(ComponentEvent e) {
        int w = this.getWidth();
        int h = this.getHeight();

        if ((originalImage != null) && (w > 0) && (h > 0)) {
            image = originalImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
            this.repaint();
        }
    }

    // ����� ���������� � ���� ����.
    public void paint(Graphics g) {
        // ������ ��������
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
        super.paintChildren(g);

        super.paintBorder(g);
    }

    // ������ ��� ��������� ��������.
    public BufferedImage getImage() {
        return originalImage;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setImageFile(File imageFile) {
        try {
            if (imageFile == null) {
                originalImage = null;
            }
            BufferedImage bi = ImageIO.read(imageFile);
            originalImage = bi;
        } catch (IOException e) {
            System.out.println("�� ������� ��������� ��������");
            e.printStackTrace();
        }
        repaint();
    }

    // http://base.vingrad.ru/view/2024-Dobavlenie-kartinki-na-JFrame - ������
}
