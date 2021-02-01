public class BufferStorageUnit {
}


/*

    1) En verkstad ska kunna ta emot ("lasta"?) ett antal bilar, upp till något max-antal som kan variera mellan olika verkstäder.
    2) Vissa verkstäder ska bara kunna ta emot en viss sorts bilar; andra kan ta emot vilka bilar som helst.
    3) Att försöka lämna in "fel" sorts bil i en verkstad ska ge ett statiskt (compile time) fel.
    4) Vid uthämtning av en bil från verkstaden ska vi kunna få så precis typinformation som möjligt statiskt.
        Exempel: För en märkesverkstad som enbart hanterar Volvo 240 bör vi statiskt kunna veta att bilar som hämtas ut från verkstaden alltid är just Volvo 240.


 */