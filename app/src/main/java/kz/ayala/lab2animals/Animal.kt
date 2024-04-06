package kz.ayala.lab2animals

data class Animal(
    val name: String,
    val taxonomy: Taxonomy,
    val locations: List<String>,
    val characteristics: Characteristics
)

data class Taxonomy(
    val scientific_name: String
)

data class Characteristics(
    val estimated_population_size: String,
    val biggest_threat: String,
    val top_speed: String,
    val lifespan: String
)