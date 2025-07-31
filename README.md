# Esercizio Java: Pizzeria WebAPI

### Continuo della repository spring-la-mia-pizzeria-relazioni

## Descrizione

Il progetto complessivo consiste nello sviluppo di un’applicazione web per la gestione di una pizzeria, che permette di gestire pizze, offerte speciali e ingredienti, con funzionalità complete di CRUD (creazione, lettura, aggiornamento, cancellazione) sia tramite interfaccia grafica che API REST.

L’applicazione prevede diverse pagine principali: una lista delle pizze con possibilità di filtro per nome, la visualizzazione dettagliata di ogni singola pizza, e pagine per la creazione, modifica e cancellazione delle pizze. Ogni pizza include informazioni come id, nome, descrizione, foto e prezzo, con validazioni per i dati inseriti.

Sono implementate funzionalità avanzate come la gestione delle offerte speciali legate alle pizze, che hanno una data di inizio, una data di fine e un titolo, visualizzabili nella pagina dettagliata della pizza con possibilità di aggiungere e modificare offerte.

Inoltre, è prevista la gestione degli ingredienti, che possono essere associati a più pizze (e viceversa), con pagine dedicate per elencare, creare e cancellare ingredienti e per associarli alle pizze durante la creazione o modifica.

Infine, è stata aggiunta l’esposizione di endpoint REST per tutte le operazioni CRUD sulle pizze, permettendo di interagire con il backend tramite strumenti come Postman, garantendo così anche un accesso programmabile e un’integrazione possibile con altre applicazioni.
