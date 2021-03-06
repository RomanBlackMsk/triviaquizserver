/*
 * Copyright (c) 2009, Lauren Darcey and Shane Conder
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are 
 * permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this list of 
 *   conditions and the following disclaimer.
 *   
 * * Redistributions in binary form must reproduce the above copyright notice, this list 
 *   of conditions and the following disclaimer in the documentation and/or other 
 *   materials provided with the distribution.
 *   
 * * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used
 *   to endorse or promote products derived from this software without specific prior 
 *   written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF 
 * THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.androidbook.triviaquizserver;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TriviaQuizQuestions {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Long number;

    @Persistent
    private String triviaQuestion;

    @Persistent
    private Blob questionImage;
    
    @Persistent
    private Boolean approved;
    
    @Persistent
    private Long suggester;

    public TriviaQuizQuestions(Long number, String triviaQuestion, Blob questionImage) {
        super();
        this.number = number;
        this.triviaQuestion = triviaQuestion;
        this.questionImage = questionImage;
        suggester = -1L;
        this.approved = true;
    }

    public TriviaQuizQuestions(String triviaQuestion, Blob questionImage, Long suggester) {
        super();
        this.number = -1L;
        this.triviaQuestion = triviaQuestion;
        this.questionImage = questionImage;
        this.suggester = suggester;
        this.approved = false;
    }
    
    public Long getSuggester() {
        return suggester;
    }

    public void setSuggestor(Long suggester) {
        this.suggester = suggester;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTriviaQuestion() {
        return triviaQuestion;
    }

    public void setTriviaQuestion(String triviaQuestion) {
        this.triviaQuestion = triviaQuestion;
    }

    public String getQuestionImageUrl() {
        return "/qi?key=" + getId();
    }

    public Long getId() {
        return id;
    }

    public void setQuestionImage(Blob questionImage) {
        this.questionImage = questionImage;
    }

    public Blob getQuestionImage() {
        return questionImage;
    }
}
