# Aufgabenstellung RESTful Webservices

Nutzen Sie für diese Aufgabenstellung dieses Template und führen Sie die vorbereitentenden Tätigkeiten aus, wie sie in der [README-Datei](README.md) beschrieben sind.

## Mapping von Entitätsklassen auf XML und JSON

Im Package `entity` befindet sich die Entitäts-Klasse `Student`. Diese ist mit der Annotation `@XmlRootElement` versehen und hat einen Konstruktor ohne Parameter.
Erklären Sie, wofür beide notwendig sind und erklären Sie auch die Wirkungsweise der weiteren Annotationen `@XmlRootElement`, `@XmlAccessor` oder `@XmlAttribute` für ein Java-XML-Binding.

Erstellen Sie eine weitere Klasse `Adresse` mit den Attributen `strasse`, `plz` und `ort`.

Die Klasse `Student` soll um ein Attribut `anschrift` des Typs `Adresse` ergänzt werden.

## JAX-RS-Annotationen

Die Methodenrümpfe der Klasse `StudentService` im Package `service` sind bereits vorgegeben. Implementieren Sie für jede vorgegebene Methode jeweils eine simple Funktionalität, die die übergebenen Objekte zum Beispiel in einer statischen Liste (als "interne Datenbank") verwaltet oder Standard- oder Eingabewerte erzeugt bzw. auf der Konsole ausgibt.

Nach dem REST-Paradigma, das Sie aus der Vorlesung bereits kennen, sollen obige Methoden mit entsprechenden URIs verbunden bzw. aufrufbar werden.

Ergänzen Sie die Klasse `StudentService` um alle notwendigen JAX-RS-Annotationen, so dass der *Student-Service* über eine RESTful-Webservice-Schnittstelle verfügt.

Die URI einer `Student`-Ressource mit der Matrikelnummer 981234 sei beispielhaft:

`http://localhost:8081/restapi/studentaffairs/students/981234`

Nutzen Sie diese Angaben aus dem obigen Beispiel, um die notwendigen Annotationen entsprechend zu setzen. Der Port sowie der Kontextpfad `restapi` ist bereits in der Klasse `app.Server` voreingestellt und könnte dort auch angepasst werden. `localhost` kann natürlich jederzeit durch den eigenen *Netzwerk-Hostname* bzw. die *IP-Adresse* ausgetauscht werden, damit der Service auch über das Netzwerk aufrufbar wird.  

Die zulässigen Media-Typen (XML, JSON, ...), die jeweils beim Aufruf akzeptiert werden oder die als Rückantwort gesendet werden, müssen über die Annotationen `@Consumes` und `@Produces` für jede Methode festgelegt werden, z. B. `@Produces(MediaType.APPLICATION_JSON)` oder `@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})`.

## Tests

Testen Sie Ihre Implementierung jeweils mit einem generischen REST-Client (Browser-Plugins).