package com.example.android.publicapiapp

import com.example.android.publicapiapp.adapter.CharacterDiffCallBack
import com.example.android.publicapiapp.model.CharacterObject
import com.example.android.publicapiapp.model.apiResponse.BreakingBadResponse
import com.example.android.publicapiapp.repo.BreakingBadRepository
import com.example.android.publicapiapp.repo.mapper.ResponseMapper
import io.mockk.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun repoGetsListOfCharacters(){
        val repo = mockk<BreakingBadRepository>()

        coEvery { repo.getCharacters() } returns emptyList()

        GlobalScope.launch {
            repo.getCharacters()
        }

        coVerify { repo.getCharacters() }
    }

    @Test
    fun mapperReturnsListOfCharacters(){
        val mapper = mockk<ResponseMapper>()

        val response = mockk<BreakingBadResponse>()

        every { mapper.getCharacters(response) } returns mutableListOf()

        mapper.getCharacters(response)

        verify { mapper.getCharacters(response) }
    }

    @Test
    fun characterDiffCallBackReturnsItemsAreNotSame(){
        val characterDiff = mockk<CharacterDiffCallBack>()

        val char1 = mockk<CharacterObject>()
        val char2 = mockk<CharacterObject>()

        every { characterDiff.areItemsTheSame(char1, char2) } returns false

        characterDiff.areItemsTheSame(char1, char2)

        verify { characterDiff.areItemsTheSame(char1, char2) }
    }

    @Test
    fun characterDiffCallBackReturnsContentsAreNotSame(){
        val characterDiff = mockk<CharacterDiffCallBack>()

        val char1 = mockk<CharacterObject>()
        val char2 = mockk<CharacterObject>()

        every { characterDiff.areContentsTheSame(char1, char2) } returns false

        characterDiff.areContentsTheSame(char1, char2)

        verify { characterDiff.areContentsTheSame(char1, char2) }
    }
}
