/*
 * Copyright 2019-2019 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.javaps.backend.scale;

import org.n52.javaps.backend.scale.api.Job;
import org.n52.javaps.backend.scale.api.JobType;
import org.n52.javaps.backend.scale.api.JobTypes;
import org.n52.javaps.backend.scale.api.QueueJob;
import org.n52.javaps.backend.scale.api.QueueRecipe;
import org.n52.javaps.backend.scale.api.Recipe;
import org.n52.javaps.backend.scale.api.RecipeType;
import org.n52.javaps.backend.scale.api.RecipeTypes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Interface for accessing a <a href="http://gmudcos.hopto.org/service/scale/
 *docs/rest/index.html">Scale REST API</a>.
 *
 * User sub services:
 * <ul>
 * <li><a href="http://gmudcos.hopto.org/service/scale/docs/rest/
 *job.html">Job Services</a></li>
 * <li><a href="http://gmudcos.hopto.org/service/scale/docs/rest/
 *job_type.html">Job Type Services</a></li>
 * <li><a href="http://gmudcos.hopto.org/service/scale/docs/rest/
 *queue.html">Queue Services</a></li>
 * <li><a href="http://gmudcos.hopto.org/service/scale/docs/rest/
 *recipe_type.html">Recipe Type Services</a></li>
 * <li><a href="http://gmudcos.hopto.org/service/scale/docs/rest/
 *recipe.html">Recipe Services</a></li>
 * </ul>
 *
 * @author <a href="mailto:e.h.juerrens@52north.org">J&uuml;rrens, Eike Hinderk</a>
 *
 * @since 1.4.0
 */
public interface ScaleService {

    String QUERY_PARAM_KEY_PAGE = "page";

    // http://gmudcos.hopto.org/service/scale/docs/rest/recipe_type.html#rest-recipe-type-list
    @GET("recipe-types/")
    Call<RecipeTypes> getRecipeTypes(@Header("Cookie") String dcosAuthCookie);

    // http://gmudcos.hopto.org/service/scale/docs/rest/recipe_type.html#rest-recipe-type-list
    @GET("recipe-types/")
    Call<RecipeTypes> getRecipeTypes(@Header("Cookie") String dcosAuthCookie, @Query("page") int page);

    // http://gmudcos.hopto.org/service/scale/docs/rest/recipe_type.html#rest-recipe-type-details
    @GET("recipe-types/{id}/")
    Call<RecipeType> getRecipeType(@Header("Cookie") String dcosAuthCookie, @Path("id") int id);

    // http://gmudcos.hopto.org/service/scale/docs/rest/job_type.html#rest-job-type-list
    @GET("job-types/")
    Call<JobTypes> getJobTypes(@Header("Cookie") String dcosAuthCookie);

    // http://gmudcos.hopto.org/service/scale/docs/rest/job_type.html#rest-job-type-list
    @GET("job-types/")
    Call<JobTypes> getJobTypes(@Header("Cookie") String dcosAuthCookie, @Query("page") int page);

    // http://gmudcos.hopto.org/service/scale/docs/rest/job_type.html#rest-job-type-details
    @GET("job-types/{id}/")
    Call<JobType> getJobType(@Header("Cookie") String dcosAuthCookie, @Path("id") int id);

    // http://gmudcos.hopto.org/service/scale/docs/rest/queue.html
    @POST("queue/new-recipe/")
    Call<Void> schedule(@Header("Cookie") String dcosAuthCookie, @Body QueueRecipe queueRecipe);

    // http://gmudcos.hopto.org/service/scale/docs/rest/queue.html
    @POST("queue/new-job/")
    Call<Void> schedule(@Header("Cookie") String dcosAuthCookie, @Body QueueJob queueJob);

    // http://gmudcos.hopto.org/service/scale/docs/rest/recipe.html#rest-recipe-details
    @GET("recipes/{id}/")
    Call<Recipe> getRecipe(@Header("Cookie") String dcosAuthCookie, @Path("id") int id);

    // http://gmudcos.hopto.org/service/scale/docs/rest/job.html#rest-job-details
    @GET("jobs/{id}/")
    Call<Job> getJob(@Header("Cookie") String dcosAuthCookie, @Path("id") int id);
}
