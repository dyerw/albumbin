(ns albumbin.routes.album
  (:require [compojure.core :refer [defroutes GET POST]]
            [ring.util.response :refer [response]]
            [clojure.java.io :as io]
            [buddy.auth.accessrules :refer [restrict]]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [albumbin.db.core :as db]))

(defn get-albums-for-week [week]
  {:status 500 :body {:error "not implemented"}})

(defn validate-album [params]
  (first 
    (b/validate params
                :musicbrainzid v/required
                :review [v/required [v/max-count 1000]])))

(defn create-album! [params]
  (if-let [error (validate-album params)]
    {:status 400 :body {:error error}}
    (do
      (db/create-album! (merge params
                               {:created (java.util.Date.) :userid 1}))
      {:status 201})))

(defroutes album-routes
  (GET "/album" {{week :week} :params} (get-albums-for-week week))
  (POST "/album" {params :params} (create-album! params)))

