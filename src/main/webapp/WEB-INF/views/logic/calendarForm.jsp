
<div class="modal fade" tabindex="-1" role="dialog" id="modal1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Create new event</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="name">Nom</label>
                        <input type="text" name="name" id="name" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="starts-at">Starts at</label>
                        <input type="text" name="starts_at" id="starts-at" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="ends-at">Ends at</label>
                        <input type="text" name="ends_at" id="ends-at" />
                    </div>
                </div>
                 <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="place">Place</label>
                        <input type="text" name="place" id="place" />
                    </div>
                </div>
                
                 <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="priority">Priorié</label>
                        <input type="text" name="prority" id="priority" />
                    </div>
                </div>
                 <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="objectif">Objectifs</label>
		                <select name="objectif">
		                  <option value="Greece" selected="selected">Aucun</option>
						  <c:forEach items="${objectifs}" var="objectif">
						    <option value="${objectif.getName()}">
						        ${databaseValue}
						    </option>
						  </c:forEach>
						</select>
					</div>
				 </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="newObjectifButton" class="btn btn-default">Créer un objectif
               </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save-event">Save changes</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" tabindex="-1" role="dialog" id="modal2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal2" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Create new event</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="name">Nom objectif</label>
                        <input type="text" name="name" id="name" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="starts-at">Date de début</label>
                        <input type="text" name="starts_at" id="starts-at" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="ends-at">Date de fin</label>
                        <input type="text" name="ends_at" id="ends-at" />
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="newObjectifButton" class="btn btn-default">Créer un objectif
               </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save-event">Save changes</button>
            </div>
        </div>
    </div>
</div> 
