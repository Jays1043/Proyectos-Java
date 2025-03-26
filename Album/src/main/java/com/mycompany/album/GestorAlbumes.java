/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.album;

/**
 *
 * @author aleja
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.ArrayList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

class GestorAlbumes {

    ArrayList<Album> albumes;

    public GestorAlbumes() {
        albumes = new ArrayList<>();
    }

    public void agregarAlbum(Album album) {
        albumes.add(album);
    }

    public void guardarAlbumes() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("albumes");
            doc.appendChild(rootElement);

            for (Album album : albumes) {
                Element albumElement = doc.createElement("album");
                rootElement.appendChild(albumElement);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(album.nombre));
                albumElement.appendChild(nombre);

                Element fotos = doc.createElement("fotos");
                albumElement.appendChild(fotos);

                if (album.inicio != null) {
                    Foto actual = album.inicio;
                    do {
                        Element ruta = doc.createElement("ruta");
                        ruta.appendChild(doc.createTextNode(actual.ruta));
                        fotos.appendChild(ruta);
                        actual = actual.siguiente;
                    } while (actual != album.inicio);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("albumes.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarAlbumes() {
        try {
            File archivo = new File("albumes.xml");
            if (!archivo.exists()) {
                return; // Si el archivo no existe, no hay nada que cargar.
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);
            doc.getDocumentElement().normalize();

            NodeList listaAlbumes = doc.getElementsByTagName("album");

            for (int i = 0; i < listaAlbumes.getLength(); i++) {
                Node nodoAlbum = listaAlbumes.item(i);
                if (nodoAlbum.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoAlbum = (Element) nodoAlbum;

                    String nombreAlbum = elementoAlbum.getElementsByTagName("nombre").item(0).getTextContent();
                    Album album = new Album(nombreAlbum);
                    agregarAlbum(album);

                    NodeList listaFotos = elementoAlbum.getElementsByTagName("ruta");
                    for (int j = 0; j < listaFotos.getLength(); j++) {
                        String rutaFoto = listaFotos.item(j).getTextContent();
                        album.agregarFoto(rutaFoto);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
