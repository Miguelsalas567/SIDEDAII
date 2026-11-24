package sistemaepn;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Sistema EPN - Interfaz principal
 * Compatible con Java 8+ (recomendado Java 11) y NetBeans.
 */
public class VentanaPrincipal extends JFrame {

    private static final Color AZUL = new Color(17, 43, 73);
    private static final Color AZUL_CLARO = new Color(29, 67, 105);
    private static final Color ROJO = new Color(190, 30, 45);
    private static final Color DORADO = new Color(226, 177, 65);
    private static final Color FONDO = new Color(244, 247, 251);
    private static final Color TEXTO = new Color(39, 52, 68);
    private static final Color GRIS = new Color(111, 125, 142);
    private static final Color BORDE_SUAVE = new Color(225, 231, 238);

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contenedor = new JPanel(cardLayout);

    public VentanaPrincipal() {
        configurarVentana();
        construirInterfaz();
        mostrarPantalla("INICIO");
    }

    private void configurarVentana() {
        setTitle("Sistema EPN | Estructura de Datos y Algoritmos II");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1050, 680));
        setSize(1250, 780);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(FONDO);
    }

    private void construirInterfaz() {
        add(crearBarraLateral(), BorderLayout.WEST);

        contenedor.setBackground(FONDO);
        contenedor.add(crearInicio(), "INICIO");
        contenedor.add(crearSeccion(
                "Eficiencia algorítmica",
                "Estudia el rendimiento de un algoritmo según los recursos que utiliza.",
                new String[]{"Ejercicios de eficiencia algorítmica"},
                new String[]{"EFICIENCIA_EJERCICIOS"}), "EFICIENCIA");

        contenedor.add(crearSeccion(
                "Análisis de complejidad",
                "Analiza cómo crece el tiempo y el espacio requerido por un algoritmo.",
                new String[]{"Notación Big O", "Notación Big Omega (Ω)", "Notación Big Theta (Θ)"},
                new String[]{"BIG_O", "BIG_OMEGA", "BIG_THETA"}), "COMPLEJIDAD");

        contenedor.add(crearSeccion(
                "Clases de complejidad",
                "Explora los conceptos y problemas relacionados con P, NP y sus variantes.",
                new String[]{"Clase P", "Clase NP", "NP-Hard", "NP-Completo"},
                new String[]{"CLASE_P", "CLASE_NP", "NP_HARD", "NP_COMPLETO"}), "PNP");

        contenedor.add(crearMenuGrafos(), "GRAFOS");

        contenedor.add(crearPantallaEjercicio("Ejercicios de eficiencia algorítmica",
                "Aquí se incorporarán ejercicios interactivos para ingresar datos y evaluar la eficiencia.",
                "EFICIENCIA_EJERCICIOS"), "EFICIENCIA_EJERCICIOS");

        contenedor.add(crearPantallaEjercicio("Notación Big O",
                "Aquí podrás analizar el límite superior del crecimiento de un algoritmo.",
                "BIG_O"), "BIG_O");
        contenedor.add(crearPantallaEjercicio("Notación Big Omega (Ω)",
                "Aquí podrás analizar el límite inferior del crecimiento de un algoritmo.",
                "BIG_OMEGA"), "BIG_OMEGA");
        contenedor.add(crearPantallaEjercicio("Notación Big Theta (Θ)",
                "Aquí podrás analizar el crecimiento ajustado de un algoritmo.",
                "BIG_THETA"), "BIG_THETA");

        contenedor.add(crearPantallaEjercicio("Clase P",
                "Ejercicios interactivos sobre problemas que pueden resolverse en tiempo polinómico.",
                "CLASE_P"), "CLASE_P");
        contenedor.add(crearPantallaEjercicio("Clase NP",
                "Ejercicios sobre problemas cuyas soluciones pueden verificarse en tiempo polinómico.",
                "CLASE_NP"), "CLASE_NP");
        contenedor.add(crearPantallaEjercicio("NP-Hard",
                "Ejercicios para estudiar problemas al menos tan difíciles como los de NP.",
                "NP_HARD"), "NP_HARD");
        contenedor.add(crearPantallaEjercicio("NP-Completo",
                "Ejercicios sobre problemas que pertenecen a NP y son NP-Hard.",
                "NP_COMPLETO"), "NP_COMPLETO");

        contenedor.add(crearPantallaEjercicio("Ordenamiento topológico",
                "Resolución de ordenamientos válidos en grafos dirigidos acíclicos.",
                "ORDEN_TOPOLOGICO"), "ORDEN_TOPOLOGICO");
        contenedor.add(crearPantallaEjercicio("TSM - Travelling Salesman",
                "Busca un recorrido de costo mínimo que visite cada ciudad y regrese al origen.",
                "TSM"), "TSM");
        contenedor.add(crearPantallaEjercicio("Algoritmo de Prim",
                "Construcción de un árbol de expansión mínima en un grafo ponderado y conexo.",
                "PRIM"), "PRIM");
        contenedor.add(crearPantallaEjercicio("Algoritmo de Kahn",
                "Obtención de un orden topológico mediante el uso de grados de entrada.",
                "KAHN"), "KAHN");
        contenedor.add(crearPantallaEjercicio("Algoritmo de Kruskal",
                "Construcción de un árbol de expansión mínima seleccionando aristas de menor peso.",
                "KRUSKAL"), "KRUSKAL");
        contenedor.add(crearPantallaEjercicio("Algoritmo de Dijkstra",
                "Cálculo de caminos mínimos desde un vértice de origen.",
                "DIJKSTRA"), "DIJKSTRA");

        add(contenedor, BorderLayout.CENTER);
    }

    private JPanel crearBarraLateral() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(270, 0));
        sidebar.setBackground(AZUL);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(24, 16, 18, 16));

        JPanel marca = new JPanel();
        marca.setOpaque(false);
        marca.setLayout(new BoxLayout(marca, BoxLayout.X_AXIS));
        marca.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel logo = cargarLogo();
        logo.setAlignmentY(Component.CENTER_ALIGNMENT);
        marca.add(logo);
        marca.add(Box.createHorizontalStrut(10));

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.setAlignmentY(Component.CENTER_ALIGNMENT);

        String[] lineasInstitucion = {"ESCUELA", "POLITÉCNICA", "NACIONAL"};
        for (String linea : lineasInstitucion) {
            JLabel lbl = new JLabel(linea);
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("SansSerif", Font.BOLD, 14));
            lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            textos.add(lbl);
        }
        marca.add(textos);

        sidebar.add(marca);
        sidebar.add(Box.createVerticalStrut(32));

        JLabel menu = new JLabel("MENÚ PRINCIPAL");
        menu.setForeground(new Color(179, 195, 212));
        menu.setFont(new Font("SansSerif", Font.BOLD, 11));
        menu.setBorder(new EmptyBorder(0, 8, 0, 0));
        menu.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(menu);
        sidebar.add(Box.createVerticalStrut(12));

        sidebar.add(crearBotonMenu("⌂", "Inicio", "INICIO"));
        sidebar.add(Box.createVerticalStrut(4));
        sidebar.add(crearBotonMenu("◈", "Eficiencia algorítmica", "EFICIENCIA"));
        sidebar.add(Box.createVerticalStrut(4));
        sidebar.add(crearBotonMenu("▥", "Análisis de complejidad", "COMPLEJIDAD"));
        sidebar.add(Box.createVerticalStrut(4));
        sidebar.add(crearBotonMenu("◎", "P - NP y variantes", "PNP"));
        sidebar.add(Box.createVerticalStrut(4));
        sidebar.add(crearBotonMenu("⌘", "Teoría de grafos", "GRAFOS"));

        sidebar.add(Box.createVerticalGlue());

        JSeparator separador = new JSeparator();
        separador.setForeground(new Color(65, 89, 115));
        separador.setBackground(new Color(65, 89, 115));
        separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separador.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(separador);
        sidebar.add(Box.createVerticalStrut(15));

        JLabel pie = new JLabel("<html><div style='text-align:center;'>ESTRUCTURA DE DATOS<br>Y ALGORITMOS II<br><br>PROYECTO ACADÉMICO · 2026</div></html>");
        pie.setForeground(new Color(185, 198, 211));
        pie.setFont(new Font("SansSerif", Font.PLAIN, 10));
        pie.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(pie);

        return sidebar;
    }

    private JLabel cargarLogo() {
        JLabel label = new JLabel("EPN") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getIcon() == null) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(AZUL_CLARO);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                    g2.setColor(DORADO);
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
                    g2.dispose();
                }
                super.paintComponent(g);
            }
        };
        label.setPreferredSize(new Dimension(62, 62));
        label.setMinimumSize(new Dimension(62, 62));
        label.setMaximumSize(new Dimension(62, 62));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 17));

        URL url = getClass().getResource("/recursos/logo_epn.png");
        if (url != null) {
            ImageIcon original = new ImageIcon(url);
            Image imagen = original.getImage().getScaledInstance(62, 62, Image.SCALE_SMOOTH);
            label.setText("");
            label.setIcon(new ImageIcon(imagen));
        } else {
            label.setToolTipText("Coloca logo_epn.png en src/recursos/");
        }
        return label;
    }

    private JButton crearBotonMenu(String icono, String texto, String destino) {
        JButton boton = new JButton(icono + "   " + texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 46));
        boton.setPreferredSize(new Dimension(235, 46));
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setForeground(new Color(235, 241, 247));
        boton.setBackground(AZUL);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 13));
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(0, 12, 0, 8));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.addActionListener(e -> mostrarPantalla(destino));
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(AZUL_CLARO);
                boton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(AZUL);
                boton.repaint();
            }
        });
        return boton;
    }

    private JPanel crearInicio() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);
        panel.setBorder(new EmptyBorder(28, 34, 28, 34));

        JPanel encabezado = new JPanel();
        encabezado.setOpaque(false);
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel saludo = new JLabel("Bienvenido al Sistema EPN");
        saludo.setFont(new Font("SansSerif", Font.BOLD, 29));
        saludo.setForeground(AZUL);
        saludo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descripcion = new JLabel("Selecciona una categoría para comenzar a resolver los ejercicios.");
        descripcion.setFont(new Font("SansSerif", Font.PLAIN, 15));
        descripcion.setForeground(GRIS);
        descripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

        encabezado.add(saludo);
        encabezado.add(Box.createVerticalStrut(8));
        encabezado.add(descripcion);
        encabezado.add(Box.createVerticalStrut(24));

        JPanel banner = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(AZUL);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        banner.setOpaque(false);
        banner.setBorder(new EmptyBorder(22, 25, 22, 25));
        banner.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel bannerTitulo = new JLabel("<html><div style='color:white;font-size:20px;font-weight:bold;'>ESTRUCTURA DE DATOS Y ALGORITMOS II</div>"
                + "<div style='color:#E2B141;font-size:13px;margin-top:7px;'>Aprende, analiza y ejecuta algoritmos</div></html>");
        banner.add(bannerTitulo, BorderLayout.CENTER);
        encabezado.add(banner);

        JLabel seccion = new JLabel("CATEGORÍAS DE APRENDIZAJE");
        seccion.setFont(new Font("SansSerif", Font.BOLD, 13));
        seccion.setForeground(TEXTO);
        seccion.setBorder(new EmptyBorder(24, 0, 12, 0));
        seccion.setAlignmentX(Component.LEFT_ALIGNMENT);
        encabezado.add(seccion);

        JPanel tarjetas = new JPanel(new GridLayout(2, 2, 18, 18));
        tarjetas.setOpaque(false);
        tarjetas.add(crearTarjeta("01", "Eficiencia algorítmica",
                "Ejercicios para estudiar el rendimiento de los algoritmos.",
                "EFICIENCIA", "▶"));
        tarjetas.add(crearTarjeta("02", "Análisis de complejidad",
                "Notaciones asintóticas y crecimiento de funciones.",
                "COMPLEJIDAD", "▥"));
        tarjetas.add(crearTarjeta("03", "P - NP y variantes",
                "P, NP, NP-Hard y NP-Completo.",
                "PNP", "◎"));
        tarjetas.add(crearTarjeta("04", "Teoría de grafos",
                "Orden topológico, TSM, Prim, Kahn, Kruskal y Dijkstra.",
                "GRAFOS", "⌘"));

        JPanel centro = new JPanel(new BorderLayout());
        centro.setOpaque(false);
        centro.add(encabezado, BorderLayout.NORTH);
        centro.add(tarjetas, BorderLayout.CENTER);

        JLabel pie = new JLabel("ESCUELA POLITÉCNICA NACIONAL  |  SISTEMA ACADÉMICO DE EJERCICIOS");
        pie.setForeground(GRIS);
        pie.setFont(new Font("SansSerif", Font.PLAIN, 10));
        pie.setBorder(new EmptyBorder(18, 0, 0, 0));

        panel.add(centro, BorderLayout.CENTER);
        panel.add(pie, BorderLayout.SOUTH);
        return panel;
    }

    private JButton crearTarjeta(String numero, String titulo, String descripcion,
                                 String destino, String icono) {
        final Color[] bordeColor = {BORDE_SUAVE};
        final int[] grosorBorde = {1};

        JButton boton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.setColor(bordeColor[0]);
                g2.setStroke(new BasicStroke(grosorBorde[0]));
                int inset = grosorBorde[0] / 2;
                g2.drawRoundRect(inset, inset, getWidth() - grosorBorde[0], getHeight() - grosorBorde[0], 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        boton.setLayout(new BorderLayout(10, 10));
        boton.setBackground(Color.WHITE);
        boton.setBorder(new EmptyBorder(18, 20, 18, 20));
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel arriba = new JPanel(new BorderLayout());
        arriba.setOpaque(false);
        JLabel num = new JLabel(numero);
        num.setForeground(ROJO);
        num.setFont(new Font("SansSerif", Font.BOLD, 13));
        JLabel ico = new JLabel(icono);
        ico.setForeground(DORADO);
        ico.setFont(new Font("SansSerif", Font.BOLD, 27));
        arriba.add(num, BorderLayout.WEST);
        arriba.add(ico, BorderLayout.EAST);

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        JLabel nombre = new JLabel(titulo);
        nombre.setForeground(AZUL);
        nombre.setFont(new Font("SansSerif", Font.BOLD, 17));
        nombre.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel detalle = new JLabel("<html><div style='color:#6F7D8E;font-size:12px;'>"
                + descripcion + "</div></html>");
        detalle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        detalle.setAlignmentX(Component.LEFT_ALIGNMENT);

        textos.add(nombre);
        textos.add(Box.createVerticalStrut(8));
        textos.add(detalle);

        JLabel abrir = new JLabel("Abrir sección  →");
        abrir.setForeground(ROJO);
        abrir.setFont(new Font("SansSerif", Font.BOLD, 12));

        boton.add(arriba, BorderLayout.NORTH);
        boton.add(textos, BorderLayout.CENTER);
        boton.add(abrir, BorderLayout.SOUTH);

        boton.addActionListener(e -> mostrarPantalla(destino));
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bordeColor[0] = DORADO;
                grosorBorde[0] = 2;
                boton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bordeColor[0] = BORDE_SUAVE;
                grosorBorde[0] = 1;
                boton.repaint();
            }
        });
        return boton;
    }

    private JPanel crearSeccion(String titulo, String descripcion,
                                String[] opciones, String[] destinos) {
        JPanel panel = crearBaseContenido();
        panel.add(crearEncabezado(titulo, descripcion), BorderLayout.NORTH);

        JPanel lista = new JPanel();
        lista.setOpaque(false);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBorder(new EmptyBorder(25, 0, 0, 0));

        for (int i = 0; i < opciones.length; i++) {
            final String destino = destinos[i];
            JButton boton = crearBotonOpcion(opciones[i], destino);
            lista.add(boton);
            lista.add(Box.createVerticalStrut(12));
        }

        panel.add(lista, BorderLayout.CENTER);
        return panel;
    }

    private JButton crearBotonOpcion(String texto, String destino) {
        JButton boton = new JButton("  " + texto + "     →") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.setColor(BORDE_SUAVE);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setFont(new Font("SansSerif", Font.BOLD, 14));
        boton.setForeground(AZUL);
        boton.setBackground(Color.WHITE);
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(16, 18, 16, 18));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 58));
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.addActionListener(e -> mostrarPantalla(destino));
        return boton;
    }

    private JPanel crearMenuGrafos() {
        JPanel panel = crearBaseContenido();
        panel.add(crearEncabezado("Teoría de grafos",
                "Selecciona el algoritmo que deseas ejecutar o estudiar."), BorderLayout.NORTH);

        String[] nombres = {
            "Ordenamiento topológico", "TSM - Travelling Salesman",
            "Algoritmo de Prim", "Algoritmo de Kahn",
            "Algoritmo de Kruskal", "Algoritmo de Dijkstra"
        };
        String[] destinos = {
            "ORDEN_TOPOLOGICO", "TSM", "PRIM", "KAHN", "KRUSKAL", "DIJKSTRA"
        };

        JPanel grid = new JPanel(new GridLayout(3, 2, 15, 15));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(28, 0, 0, 0));
        for (int i = 0; i < nombres.length; i++) {
            grid.add(crearTarjetaGrafo(nombres[i], destinos[i], String.format("%02d", i + 1)));
        }
        panel.add(grid, BorderLayout.CENTER);
        return panel;
    }

    private JButton crearTarjetaGrafo(String nombre, String destino, String numero) {
        JButton boton = new JButton("<html><div style='font-size:11px;color:#BE1E2D;font-weight:bold;'>"
                + numero + "</div><div style='font-size:16px;color:#112B49;font-weight:bold;margin-top:8px;'>"
                + nombre + "</div><div style='font-size:12px;color:#6F7D8E;margin-top:9px;'>Abrir ejercicio →</div></html>") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.setColor(BORDE_SUAVE);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setBackground(Color.WHITE);
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(15, 18, 15, 18));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.addActionListener(e -> mostrarPantalla(destino));
        return boton;
    }

    private JPanel crearPantallaEjercicio(String titulo, String descripcion, String clave) {
        JPanel panel = crearBaseContenido();
        panel.add(crearEncabezado(titulo, descripcion), BorderLayout.NORTH);

        JPanel cuerpo = new JPanel(new BorderLayout(0, 18));
        cuerpo.setOpaque(false);
        cuerpo.setBorder(new EmptyBorder(25, 0, 0, 0));

        JPanel tarjeta = new JPanel();
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE_SUAVE),
                new EmptyBorder(22, 22, 22, 22)));

        JLabel subtitulo = new JLabel("Área de trabajo");
        subtitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        subtitulo.setForeground(AZUL);
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel instruccion = new JLabel("En esta sección se implementará el ejercicio interactivo.");
        instruccion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        instruccion.setForeground(GRIS);
        instruccion.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea entrada = new JTextArea(6, 35);
        entrada.setFont(new Font("Monospaced", Font.PLAIN, 13));
        entrada.setLineWrap(true);
        entrada.setWrapStyleWord(true);
        entrada.setText("Ingresa aquí los datos del ejercicio cuando se implemente el algoritmo...");
        entrada.setForeground(new Color(120, 130, 140));

        JScrollPane scroll = new JScrollPane(entrada);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(218, 225, 233)));
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton ejecutar = new JButton("▶   Ejecutar ejercicio") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(ROJO);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        ejecutar.setForeground(Color.WHITE);
        ejecutar.setFont(new Font("SansSerif", Font.BOLD, 13));
        ejecutar.setContentAreaFilled(false);
        ejecutar.setOpaque(false);
        ejecutar.setBorderPainted(false);
        ejecutar.setFocusPainted(false);
        ejecutar.setBorder(new EmptyBorder(11, 18, 11, 18));
        ejecutar.setAlignmentX(Component.LEFT_ALIGNMENT);
        ejecutar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ejecutar.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "La pantalla de " + titulo + " ya está creada.\n"
                + "En la siguiente etapa agregaremos la lógica del algoritmo y sus resultados.",
                "Módulo en preparación", JOptionPane.INFORMATION_MESSAGE));

        JLabel lblEntrada = new JLabel("Datos de entrada:");
        lblEntrada.setForeground(TEXTO);
        lblEntrada.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblEntrada.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel resultadoTitulo = new JLabel("Resultado");
        resultadoTitulo.setForeground(AZUL);
        resultadoTitulo.setFont(new Font("SansSerif", Font.BOLD, 15));
        resultadoTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea resultado = new JTextArea("Aquí se mostrarán los resultados de la ejecución.");
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        resultado.setFont(new Font("SansSerif", Font.PLAIN, 13));
        resultado.setForeground(GRIS);
        resultado.setBackground(new Color(248, 250, 252));
        resultado.setBorder(new EmptyBorder(12, 12, 12, 12));
        resultado.setAlignmentX(Component.LEFT_ALIGNMENT);

        tarjeta.add(subtitulo);
        tarjeta.add(Box.createVerticalStrut(8));
        tarjeta.add(instruccion);
        tarjeta.add(Box.createVerticalStrut(18));
        tarjeta.add(lblEntrada);
        tarjeta.add(Box.createVerticalStrut(7));
        tarjeta.add(scroll);
        tarjeta.add(Box.createVerticalStrut(13));
        tarjeta.add(ejecutar);
        tarjeta.add(Box.createVerticalStrut(20));
        tarjeta.add(resultadoTitulo);
        tarjeta.add(Box.createVerticalStrut(8));
        tarjeta.add(resultado);

        cuerpo.add(tarjeta, BorderLayout.NORTH);
        panel.add(cuerpo, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearBaseContenido() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);
        panel.setBorder(new EmptyBorder(32, 38, 30, 38));
        return panel;
    }

    private JPanel crearEncabezado(String titulo, String descripcion) {
        JPanel encabezado = new JPanel();
        encabezado.setOpaque(false);
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton volver = new JButton("←  Volver al inicio");
        volver.setFont(new Font("SansSerif", Font.BOLD, 12));
        volver.setForeground(ROJO);
        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.setFocusPainted(false);
        volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        volver.setAlignmentX(Component.LEFT_ALIGNMENT);
        volver.addActionListener(e -> mostrarPantalla("INICIO"));

        JLabel nombre = new JLabel(titulo);
        nombre.setForeground(AZUL);
        nombre.setFont(new Font("SansSerif", Font.BOLD, 27));
        nombre.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel detalle = new JLabel(descripcion);
        detalle.setForeground(GRIS);
        detalle.setFont(new Font("SansSerif", Font.PLAIN, 14));
        detalle.setAlignmentX(Component.LEFT_ALIGNMENT);

        encabezado.add(volver);
        encabezado.add(Box.createVerticalStrut(18));
        encabezado.add(nombre);
        encabezado.add(Box.createVerticalStrut(8));
        encabezado.add(detalle);
        return encabezado;
    }

    private void mostrarPantalla(String nombre) {
        cardLayout.show(contenedor, nombre);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // Se mantiene el estilo predeterminado de Swing.
        }

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}