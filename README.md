# Error Encontrados:

* Injeção de SQL:

O uso de concatenação de strings na query SQL "(sql += "where login = '" + login + "'";)". Isso faz com que seja possível SQL injection no código.

* Tratamento de exceções insuficiente:

As exceções estão sendo capturadas, porém, nada é feito, seria ideal relatar o erro para o desenvolvedor ou cliente.
</br>


* newInstance() está deprecated:

Isso significa que não é ideal permanecer usando esse método, uma vez que suporte para com ele será cessado.
</br>

* Conexões não fechadas:

As conexões, declarações e resultados não são fechados, o que pode causar vazamentos de recursos.

* conectarBD foi usado sem try catch:

Caso aconteceça algum problema ao receber o conn, o método verificaUsuario irá disparar uma exceção.



