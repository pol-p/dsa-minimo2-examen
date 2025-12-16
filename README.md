# dsa-minimo2-examen

He tenido una confusión inicial y había empezado un ejercicio en el que se daba un grupo y se retornaban todos sus usuarios. Al acabar y revisar el enunciado, me he dado cuenta de que no era eso, así que he añadido la Activity MiGrupo (que es la del ejercicio real) y he creado otro endpoint.

Endpoint /v1/grupo/{usergroup} → Retorna todos los usuarios de un grupo que tú elijas.

Endpoint /v1/grupo/user/{userId}/team → Retorna los usuarios de tu grupo en particular. Para el correcto funcionamiento, hay que loguearse con un usuario que pertenezca a algún team o grupo.

Lo positivo es que, a pesar del cambio, he podido reutilizar el adapter (GrupoAdapter) que ya había creado para la actividad anterior (GrupoActivity).
Estado del Mínimo 2 (14:00 - 16/12/2025) → Funciona todo correctamente.
