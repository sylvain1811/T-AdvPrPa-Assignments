val cities = List("Paris", "London", "Berlin", "Lausanne")
val relatives = List("Grandma", "Grandpa", "Aunt Lottie", "Dad")
val travellers = List("Pierre-Andre", "Rachel")

// a
val postCards: List[String] =
  for (t <- travellers;
       r <- relatives;
       c <- cities;
       if r.startsWith("G"))
    yield s"Dear $r, Wish you were here in $c! Love, $t"

postCards.foreach(println)