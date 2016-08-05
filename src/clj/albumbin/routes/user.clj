(ns albumbin.routes.user
  (:require [compojure.core :refer [defroutes GET POST]]
            [ring.util.response :refer [response]]
            [clojure.java.io :as io]
            [buddy.hashers :as hashers]
            [buddy.sign.jwt :as jwt]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [albumbin.db.core :as db]))

(defn create-user! [params]
  (db/create-user! (update (merge params {:id  (str (java.util.UUID/randomUUID))}) :password hashers/derive))
  {:status 201})

(defn authenticate-user [email password]
  (let [user (db/get-user-by-email {:email email})]
    (if (hashers/check password (:password user))
      (response {:token (jwt/sign {:user (:id user)} "blah")})
      {:status 401})))

(defroutes user-routes
  (GET "/user" {{email :email password :password} :params} (authenticate-user email password))
  (POST "/user" {params :params} (create-user! params)))
