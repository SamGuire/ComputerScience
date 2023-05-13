"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.postTweet = exports.getUserHomeTimeline = exports.getUserById = exports.getAllUsers = void 0;
var twitter_db_1 = require("../db/twitter.db");
var error_1 = require("../error/error");
function getAllUsers() {
    return __awaiter(this, void 0, void 0, function () {
        var query_statement, _a, rows, _, err_1;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    _b.trys.push([0, 2, , 3]);
                    query_statement = "SELECT * FROM ".concat(twitter_db_1.DB_NAME, ".users");
                    return [4 /*yield*/, twitter_db_1.default
                            .promise()
                            .query(query_statement)];
                case 1:
                    _a = _b.sent(), rows = _a[0], _ = _a[1];
                    return [2 /*return*/, rows];
                case 2:
                    err_1 = _b.sent();
                    console.error(err_1);
                    throw new error_1.TwitterServiceError(err_1.code, 500);
                case 3: return [2 /*return*/];
            }
        });
    });
}
exports.getAllUsers = getAllUsers;
function getUserById(id) {
    return __awaiter(this, void 0, void 0, function () {
        var query_statement, _a, rows, _, err_2, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    _b.trys.push([0, 2, , 3]);
                    query_statement = "SELECT * FROM ".concat(twitter_db_1.DB_NAME, ".users WHERE id= ?");
                    return [4 /*yield*/, twitter_db_1.default
                            .promise()
                            .query(query_statement, [id])];
                case 1:
                    _a = _b.sent(), rows = _a[0], _ = _a[1];
                    return [2 /*return*/, rows[0]];
                case 2:
                    err_2 = _b.sent();
                    console.error(err_2);
                    error = new error_1.TwitterServiceError(err_2.code, 500);
                    throw error;
                case 3: return [2 /*return*/];
            }
        });
    });
}
exports.getUserById = getUserById;
function getUserHomeTimeline(id) {
    return __awaiter(this, void 0, void 0, function () {
        var user_table, follows_table, tweets_table, query_statement, _a, rows, _, returnedData, err_3, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    _b.trys.push([0, 2, , 3]);
                    user_table = "".concat(twitter_db_1.DB_NAME, ".users");
                    follows_table = "".concat(twitter_db_1.DB_NAME, ".follows");
                    tweets_table = "".concat(twitter_db_1.DB_NAME, ".tweets");
                    query_statement = "SELECT ".concat(user_table, ".*,  ").concat(tweets_table, ".* FROM ") +
                        "".concat(user_table, " JOIN ").concat(follows_table, " ON ").concat(user_table, ".id = ").concat(follows_table, ".followee_id ") +
                        "JOIN ".concat(tweets_table, " on ").concat(tweets_table, ".sender_id = ").concat(follows_table, ".followee_id ") +
                        "WHERE ".concat(follows_table, ".follower_id = ? ") +
                        "ORDER BY ".concat(tweets_table, ".tweet_created_date DESC");
                    return [4 /*yield*/, twitter_db_1.default
                            .promise()
                            .query(query_statement, [id])];
                case 1:
                    _a = _b.sent(), rows = _a[0], _ = _a[1];
                    returnedData = {
                        user_id: id,
                        timeline: rows.map(function (v) {
                            var sender_id = v.sender_id, content = v.content, tweet_created_date = v.tweet_created_date;
                            return { sender_id: sender_id, content: content, tweet_created_date: tweet_created_date };
                        }),
                    };
                    return [2 /*return*/, returnedData];
                case 2:
                    err_3 = _b.sent();
                    console.error(err_3);
                    error = new error_1.TwitterServiceError(err_3.code, 500);
                    throw error;
                case 3: return [2 /*return*/];
            }
        });
    });
}
exports.getUserHomeTimeline = getUserHomeTimeline;
function postTweet(id, tweet) {
    return __awaiter(this, void 0, void 0, function () {
        var tweets_table, tweet_created_date, query_statement, _a, insertedId, _, err_4, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    _b.trys.push([0, 2, , 3]);
                    tweets_table = "".concat(twitter_db_1.DB_NAME, ".tweets");
                    tweet_created_date = new Date()
                        .toISOString()
                        .slice(0, 19)
                        .replace("T", " ");
                    query_statement = "INSERT INTO ".concat(tweets_table, " (sender_id,content,tweet_created_date) values (?,?,?)");
                    return [4 /*yield*/, twitter_db_1.default
                            .promise()
                            .query(query_statement, [id, tweet, tweet_created_date])];
                case 1:
                    _a = _b.sent(), insertedId = _a[0].insertedId, _ = _a[1];
                    return [2 /*return*/, insertedId];
                case 2:
                    err_4 = _b.sent();
                    console.error(err_4);
                    error = new error_1.TwitterServiceError(err_4.code, 500);
                    throw error;
                case 3: return [2 /*return*/];
            }
        });
    });
}
exports.postTweet = postTweet;
