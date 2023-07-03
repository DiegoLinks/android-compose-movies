package com.compose.movies.data.repository

import com.compose.movies.domain.model.Country
import com.compose.movies.domain.model.Movie

/**
 * Class to populate the app with local data.
 */

val movies = listOf(
    Movie(
        id = 0,
        title = "Synchronic",
        coverImage = "https://m.media-amazon.com/images/M/MV5BMzdlNGNiNTAtNDAyZC00NmQwLTg3ZTYtNDQ4MmNiYTc2ZmYzXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg",
        releaseYear = "2019",
        genreList = arrayListOf("Ficção científica", "Suspense"),
        mainGenre = "Ficção científica",
        voteAverage = 10.0,
        director = "Justin Benson e Aaron Moorhead",
        country = Country(
            "Estados Unidos",
            "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"
        ),
        synopsis = "Os paramédicos Steve e Dennis, de Nova Orleans, são chamados para socorrer vítimas de uma série de acidentes horríveis, eles logo descobrem a existência de uma nova droga, capaz de alterar a realidade."
    ),
    Movie(
        id = 1,
        title = "Gladiador",
        coverImage = "https://upload.wikimedia.org/wikipedia/pt/4/44/GladiadorPoster.jpg",
        releaseYear = "2000",
        genreList = arrayListOf("Aventura", "Ação"),
        mainGenre = "Aventura",
        voteAverage = 10.0,
        director = "Ridley Scott",
        country = Country(
            "Estados Unidos",
            "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"
        ),
        synopsis = "Maximus é um poderoso general romano, amado pelo povo e pelo imperador Marcus Aurelius. Antes de sua morte, o Imperador desperta a ira de seu filho Commodus ao tornar pública a sua predileção em deixar o trono para Maximus. Sedento pelo poder, Commodus mata seu pai, assume a coroa e ordena a morte de Maximus, que consegue fugir antes de ser pego, e passa a se esconder como um escravo e gladiador enquanto vai atrás de vingança."
    ),
    Movie(
        id = 2,
        title = "Ilha do Medo",
        coverImage = "https://pobreflix.org/wp-content/uploads/2020/06/s9SreIsoUwFVVIVGph6kDuahmwM-200x300.jpg",
        releaseYear = "2010",
        genreList = arrayListOf("Mistério"),
        mainGenre = "Mistério",
        voteAverage = 10.0,
        director = "Martin Scorsese",
        country = Country(
            "Estados Unidos",
            "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"
        ),
        synopsis = "Nos anos 1950, a fuga de uma assassina leva o detetive Teddy Daniels e seu parceiro a investigarem o seu desaparecimento de um quarto trancado em um hospital psiquiátrico. Lá, uma rebelião se inicia e o agente terá que enfrentar seus próprios medos."
    ),
    Movie(
        id = 3,
        title = "(500) Dias com Ela",
        coverImage = "https://media.fstatic.com/PyqUkh_2cnOq4DV-QLnOnaxDXt0=/322x478/smart/filters:format(webp)/media/movies/covers/2011/06/79a318ad4357944e02cf298b028488d4.jpg",
        releaseYear = "2009",
        genreList = arrayListOf("Romance", "Comédia"),
        mainGenre = "Romance",
        voteAverage = 10.0,
        director = "Mark Webb",
        country = Country(
            "Estados Unidos",
            "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"
        ),
        synopsis = "Um romântico escritor se surpreende quando sua namorada Summer termina o namoro repentinamente. Com isso, ele relembra vários momentos dos 500 dias que passaram juntos para tentar descobrir onde seu caso de amor se perdeu e vai redescobrindo suas verdadeiras paixões."
    ),
    Movie(
        id = 4,
        title = "Questão de tempo",
        coverImage = "https://br.web.img3.acsta.net/pictures/210/530/21053062_20131025204305591.jpg",
        releaseYear = "2013",
        genreList = arrayListOf("Romance", "Fantasia"),
        mainGenre = "Romance",
        voteAverage = 10.0,
        director = "Richard Curtis",
        country = Country(
            "Reino Unido",
            "https://www.countryflags.com/wp-content/uploads/united-kingdom-flag-png-large.png"
        ),
        synopsis = "Depois de descobrir que ele pode viajar no tempo, o jovem Tim Lake usa sua habilidade para ganhar o coração da mulher dos seus sonhos e salvar seu amigo de um desastre profissional."
    ),
    Movie(
        id = 5,
        title = "Efeito Borboleta",
        coverImage = "https://upload.wikimedia.org/wikipedia/pt/4/43/Butterflyeffect_poster.jpg",
        releaseYear = "2004",
        genreList = arrayListOf("Thriller", "Ficção científica"),
        mainGenre = "Thriller",
        voteAverage = 10.0,
        director = "Eric Bress e J. Mackye Gruber",
        country = Country(
            "Estados Unidos",
            "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"
        ),
        synopsis = "O estudante universitário Evan Treborn está aflito com dores de cabeça tão fortes que frequentemente desmaia. Enquanto está inconsciente, Evan pode viajar de volta no tempo para momentos de dificuldades na infância. Ele também pode alterar o passado para os amigos, como Kayleigh, que foi molestada pelo pai. Porém ao mudar o passado, ele pode alterar o presente, o que leva Evan a se encontrar em um pesadelo de realidades alternativas, incluindo uma onde ele está preso."
    ),
    Movie(
        id = 6,
        title = "O Preço do Amanhã",
        coverImage = "https://images.justwatch.com/poster/250515535/s592/o-preco-do-amanha",
        releaseYear = "2011",
        genreList = arrayListOf("Ficção científica", "Ação"),
        mainGenre = "Ficção científica",
        voteAverage = 10.0,
        director = "Andrew Niccol",
        country = Country(
            "Estados Unidos",
            "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"
        ),
        synopsis = "Acusado de assassinato, um homem deve descobrir como derrubar um sistema onde tempo é dinheiro e que permite que os ricos vivam para sempre, enquanto os pobres devem implorar por cada minuto de suas vidas."
    ),
    Movie(
        id = 7,
        title = "Nada de Novo no Front",
        coverImage = "https://br.web.img3.acsta.net/pictures/22/10/20/16/25/1413867.jpg",
        releaseYear = "2022",
        genreList = arrayListOf("Guerra", "Ação"),
        mainGenre = "Guerra",
        voteAverage = 10.0,
        director = "Edward Berger",
        country = Country(
            "Alemanha",
            "https://www.countryflags.com/wp-content/uploads/germany-flag-png-large.png"
        ),
        synopsis = "O adolescente Paul é convocado para atuar na linha de frente da Primeira Guerra Mundial. O jovem começa seu serviço militar de forma idealista e entusiasmada, mas logo é confrontado pela dura realidade do combate."
    ),
    Movie(
        id = 8,
        title = "1917",
        coverImage = "https://seuladogeek.com.br/wp-content/uploads/2022/08/Filme-1917.jpg",
        releaseYear = "2020",
        genreList = arrayListOf("Guerra", "Ação"),
        mainGenre = "Guerra",
        voteAverage = 10.0,
        director = "Sam Mendes",
        country = Country(
            "Reino Unido",
            "https://www.countryflags.com/wp-content/uploads/united-kingdom-flag-png-large.png"
        ),
        synopsis = "Na Primeira Guerra Mundial, dois soldados britânicos recebem ordens aparentemente impossíveis de cumprir. Em uma corrida contra o tempo, eles precisam atravessar o território inimigo e entregar uma mensagem que pode salvar 1.600 de seus companheiros."
    ),
    Movie(
        id = 9,
        title = "Cidade de Deus",
        coverImage = "https://upload.wikimedia.org/wikipedia/pt/1/10/CidadedeDeus.jpg",
        releaseYear = "2002",
        genreList = arrayListOf("Crime", "Drama"),
        mainGenre = "Crime",
        voteAverage = 10.0,
        director = "Fernando Meirelles e Kátia Lund",
        country = Country(
            "Brasil",
            "https://www.countryflags.com/wp-content/uploads/brazil-flag-png-large.png"
        ),
        synopsis = "Buscapé é um jovem pobre, negro e sensível, que cresce em um universo de muita violência. Ele vive na Cidade de Deus, favela carioca conhecida por ser um dos locais mais violentos do Rio. Amedrontado com a possibilidade de se tornar um bandido, Buscapé é salvo de seu destino por causa de seu talento como fotógrafo, o qual permite que siga carreira na profissão. É por meio de seu olhar atrás da câmera que ele analisa o dia a dia da favela em que vive, onde a violência aparenta ser infinita."
    )
)

fun getMovieById(movieId: Int): Movie? {
    return movies.find { it.id == movieId }
}
