package com.hamed.articlesviewer.mapper

import com.hamed.repository.model.ArticlesApiModel
import com.hamed.repository.model.NewsApiModel
import com.hamed.repository.model.SourceApiModel
import org.junit.Test
import org.junit.Assert.assertEquals

class ArticlesMapperTest {

    @Test
    fun newsApiModelToArticlesTest() {

        val apiModelList =
            NewsApiModel(
                "ok", "20", listOf(
                    ArticlesApiModel(
                        SourceApiModel(null, null),
                        null, null, null
                        , null, null, null, null
                    ),
                    ArticlesApiModel(
                        SourceApiModel(null, "The Hill"),
                        "author1", "title1", "description1"
                        , "http://www.google.com", "http://myimage.com/2.png",
                        "", "content1"
                    )
                )

        ).toArticles()

        assertEquals(apiModelList.size, 2)

        // null test
        assertEquals(apiModelList[0].author, "Empty author")
        assertEquals(apiModelList[0].description, "Empty description")
        assertEquals(apiModelList[0].source, "Empty source")
        assertEquals(apiModelList[0].title, "Empty title")
        assertEquals(apiModelList[0].url, "")
        assertEquals(apiModelList[0].urlToImage, "")

        // normal test
        assertEquals(apiModelList[1].author, "author1")
        assertEquals(apiModelList[1].description, "description1")
        assertEquals(apiModelList[1].source, "The Hill")
        assertEquals(apiModelList[1].title, "title1")
        assertEquals(apiModelList[1].url, "http://www.google.com")
        assertEquals(apiModelList[1].urlToImage, "http://myimage.com/2.png")

    }
}