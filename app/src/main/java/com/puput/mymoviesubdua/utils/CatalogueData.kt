package com.puput.mymoviesubdua.utils

import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse


object CatalogueData {

    fun generateMovieData(): List<ListMovieResponse> {
        val movie = ArrayList<ListMovieResponse>()

        movie.add(
            ListMovieResponse(
                1,
                "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "February 14, 2019",
                "Alita: The Little Battle",
                7.2,
                "2h 2m",
            )
        )
        movie.add(
            ListMovieResponse(
                2,
                "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 21, 2018",
                "Aquaman",
                6.9,
                "2h 23m",
            )
        )
        movie.add(
            ListMovieResponse(
                3,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "October 24, 2018",
                "Bohemian",
                8.0,
                "2h 15m",
            )
        )
        movie.add(
            ListMovieResponse(
                4,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "February 7, 2019",
                "Cold Persuit",
                5.7,
                "1h 59m",
            )
        )
        movie.add(
            ListMovieResponse(
                5,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "November 21, 2018",
                "Creed II",
                6.9,
                "2h 10m",
            )
        )
        movie.add(
            ListMovieResponse(
                6,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "November 14, 2018",
                "Fantastic Beasts: The Crimes of Grindelwald",
                6.9,
                "2h 14m"
            )
        )
        movie.add(
            ListMovieResponse(
                7,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "January 16, 2019",
                "Glass",
                6.7,
                "2h 9m",
            )
        )
        movie.add(
            ListMovieResponse(
                8,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "January 3, 2019",
                "How to Train Your Dragon: The Hidden World",
                7.8,
                "1h 44m",
            )
        )
        movie.add(
            ListMovieResponse(
                9,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "April 25, 2018",
                "Adventure, Action, Science Fiction",
                8.3,
                "2h 29m",
            )
        )
        movie.add(
            ListMovieResponse(
                10,
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "November 27, 2018",
                "Mortal Engines",
                6.1,
                "2h 10m",
            )
        )
        return movie
    }

    fun generateTvShow(): List<ListTvShowResponse> {
        val tvShow = ArrayList<ListTvShowResponse>()

        tvShow.add(
            ListTvShowResponse(
                11,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "October 10, 2012",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                6.6,
                "Returning Series"
            )
        )
        tvShow.add(
            ListTvShowResponse(
                12,
                "Doom Patrol ",
                "The members of the Doom Patrol now find themselves mini-sized and stranded on Cliff’s toy race car track. Here they begin to deal with their feelings of betrayal by Niles Caulder aka The Chief, while confronting their own personal baggage. And as each member faces the challenge of growing beyond their own past traumatic experiences, they must come together to embrace and protect the newest member of the family: Dorothy Spinner, Niles’ daughter, whose powers remain a mysterious but real threat to bringing on the end of the world.",
                "February 15, 2019",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                7.6,
                "Returning Series"
            )
        )
        tvShow.add(
            ListTvShowResponse(
                13,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                "Returning Series"
            )
        )
        tvShow.add(
            ListTvShowResponse(
                14,
                "Grey Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "March 27, 2005",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                8.2,
                "Returning Series"
            )
        )
        tvShow.add(
            ListTvShowResponse(
                15,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "March 28, 2019",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
                7.5,
                "Returning Series"
            )
        )
        tvShow.add(
            ListTvShowResponse(
                16,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "March 17, 2017",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
                6.6,
                "canceled",
            )
        )
        tvShow.add(
            ListTvShowResponse(
                17,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "September 23, 2003",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                7.4,
                "Returning Series",
            )
        )
        tvShow.add(
            ListTvShowResponse(
                18,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "January 26, 2017",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6,
                "Returning Series",

                )
        )
        tvShow.add(
            ListTvShowResponse(
                19,
                "SuperGirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "October 26, 2015",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
                7.2,
                "Returning Series",
            )
        )
        tvShow.add(
            ListTvShowResponse(
                20,
                "Super Natural",
                "Based on the hit animated television series, this feature film adaptation tells the story of how Blossom, Bubbles and Buttercup - three exuberant young girls - obtain their unique powers, become superheroes and join forces to foil evil mutant monkey Mojo Jojo's plan to take over the world.",
                "July 3, 2002",
                "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/qWiiB9RFKQSF4tpG2NWnZ0gjB9Q.jpg",
                6.5,
                "Returning Series",
            )
        )

        return tvShow
    }

    fun generateDetailMovie(): DetailMovie =
        DetailMovie(
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "February 14, 2019",
            "Alita: The Little Battle",
            7.2,
            "2h 2m",
            1
        )

    fun generateDetailTvShow(): DetailTVShow =
        DetailTVShow(
            "July 3, 2002",
            20,
            "Super Natural",
            "Based on the hit animated television series, this feature film adaptation tells the story of how Blossom, Bubbles and Buttercup - three exuberant young girls - obtain their unique powers, become superheroes and join forces to foil evil mutant monkey Mojo Jojo's plan to take over the world.",
            6.5,
            "https://www.themoviedb.org/t/p/w188_and_h282_bestv2/qWiiB9RFKQSF4tpG2NWnZ0gjB9Q.jpg",
            "Returning Series"
        )

}