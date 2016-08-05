(ns albumbin.routes.user
  (:require [compojure.core :refer [defroutes GET POST]]
            [ring.util.response :refer [response]]
            [clojure.java.io :as io]
            [buddy.hashers :as hashers]
            [buddy.sign.jwt :as jwt]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [albumbin.db.core :as db]))

(defn get-albums-for-week [week]
  (goddamn fuckin shit week))

(defn create-album! [params]
  ...)

(defroutes album-routes
  (GET "/album" {{week :week} :params} (get-albums-for-week week))
  (POST "/album" {params :params} (create-album! params)))
