# Challenge uala

## Search logic:
Analice varias opciones de las cuales la ultima me resulto la mejor opción.
1. La primera pero no tan eficiente era guardar todo en una base de datos usando room y cargar esos datos en un liveData.  
  En la medida que el ingresa caracteres para filtrar, se llama a un método de room para filtrar las ciudades y actualizar el liveData.
  Si bien es una opción fácil de desarrollar, no es lo suficiente optima ya que para cada consulta se debe acceder a memoria del celular que no es tan rápida como si tuviese que acceder a memoria ram.
2. La segunda opción que tenia en mente era guardar todo en un árbol de búsqueda donde cada nodo del árbol es un carácter (lowcase) y cada nodo de la frontera seria una ciudad.
  Es optimo para poder buscar un nodo ya que el tiempo depende de la cantidad de caracteres ingresados para buscar aunque luego de encontrar el nodo, hay que seguir recorriendo el resto de nodos para encontrar cada ciudad.
  lo mas costoso es cuando hay que  recorrer todos los nodos internos del árbol para encontrar las ciudades.
3. La tercer y mejor opción es guardar el listado ordenado en un array, luego puedo realizar 2 búsquedas binarias y así encontrar  la primera y la ultima coincidencia que hay en el array. Luego solo debo mostrar las ciudades que se encuentran en ese subArray.
   El tiempo de respuesta es del O(log(n)), lo que lo hace la mejor opción.



## Assumptions
- Los unicos datos que planeo guardar seran las ciudades agregadas como favoritas y seran guardadas en un DataStorage.
- Podria guardar el listado de ciudades en BD usando Room y que exista un boton  para recargar el listado pero siento que no es a lo que apunta el desafio tecnico. De todos modos en caso de disponer del tiempo suficiente intentaría implementarlo. 